import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.COMM_FAILURE;

public class MyThreadPool {
	private List<Runnable> tasksRunnable;
	private List<Callable<String>> tasksCallable;
	private ExecutorService executor;
	private  BlockingQueue<Future<String>> queue;  
	private CompletionService<String> completionService;

	public MyThreadPool() {
		tasksRunnable = new ArrayList<Runnable>();
		tasksCallable= new ArrayList<Callable<String>>();
		queue = new LinkedBlockingQueue<Future<String>>();
	}

	/**
	 * 产生线程池
	 */
	public void generateThreadPool() {
		executor = Executors.newFixedThreadPool(4);
		completionService = new ExecutorCompletionService<String>(executor);
		
	}

	/**
	 * 通过runnable参数添加任务，无参数返回
	 * 
	 * @param runnable
	 */
	public void addTask(Runnable runnable) {
		tasksRunnable.add(runnable);
	}
	
	public void addTaskList(List<Callable<String>>tasks){
		for (int i = 0; i < tasks.size(); i++) {
			completionService.submit(tasks.get(i));
			
		}
	}

	/**
	 * 通过Callable参数添加任务，有参数返回
	 * 
	 * @param runnable
	 */
	public void addTask(Callable<String> callable) {
		completionService.submit(callable);
		tasksCallable.add(callable);
		
	}

	/**
	 * 执行无返回参数的任务
	 */
	public void executeMyTask() {
		for (Runnable task : tasksRunnable) {
			executor.execute(task);
		}
	}

	/**
	 * 执行并获取所有返回值
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
//	public List<String> getAllResult() throws InterruptedException,
//			ExecutionException {
//		List<String> result = new ArrayList<String>();
//		for (Future<String> future : queue) {
//			if (!future.isDone()) {
//				result.add(future.get().toString());
//			}
//
//		}
//		return result;
//	}

	/**
	 * 执行并获取指定位置的返回值
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public String getResult(int index) throws InterruptedException,ExecutionException {
		//while (true) {
			//if (futures.get(index).isDone()&& !futures.get(index).isCancelled()) {
				return completionService.take().get();
			//}
			
		//}

	}
	
	public String getResultNoBlock() throws InterruptedException,ExecutionException {
		for (int i = 0; i < tasksCallable.size(); i++) {
			return completionService.take().get().toString();
		}
		
		return null;
	}
	
	public int getSize(){
		return tasksCallable.size();
	}

}
