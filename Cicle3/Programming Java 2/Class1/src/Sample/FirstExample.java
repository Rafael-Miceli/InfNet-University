package Sample;

public class FirstExample {

	public String getName()
	{
		return "Rafael Miceli";
	}
	
	public int CalculateTwoNumbers(int number1, int number2)
	{
		return number1 + number2;
	}
	
	public void ExecuteLoop()
	{
		//int total = 0;
		for(int i = 0; i < 1000; i++)
		{
			System.out.println(CalculateTwoNumbers(i, i +2));
		}
	}
	
	public static void main(String[] args)
	{
		FirstExample firstExample = new FirstExample();
		System.out.println(firstExample.getName());
		firstExample.ExecuteLoop();
	}
}


