import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
public class Test{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//MyThreadPool myThreadPool = new MyThreadPool();
		
		String url = "http://www.baidu.com";
		String url2 = "http://www.imooc.com/course/list?c=android";
//		Task task = new Task(url);
//		Task task2 = new Task(url2);
		MyThreadPool myThreadPool = new MyThreadPool();
		myThreadPool.generateThreadPool();
//		myThreadPool.addTask(task);
//		myThreadPool.addTask(task2);
//		myThreadPool.executeMyTask();
		
		Task2 task3 = new Task2(url2);
		Task3 task4 = new Task3(url);
		Task4 task5 = new Task4(url2);
		myThreadPool.addTask(task3);
		myThreadPool.addTask(task4);
		myThreadPool.addTask(task5);
		for (int i = 0; i < myThreadPool.getSize(); i++) {
			System.out.println(myThreadPool.getResultNoBlock());
		}

	}
}
