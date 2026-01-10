package in.ashokit;

public class Demo implements Allinone{
	public Demo(String name,String surname){
		System.out.println("param const called ");
		this.name = name ;
		this.surname = surname;
	}
	public Demo(){
		System.out.println("def cons called");
	}
	String name ;
	String surname;
	@Override
	public void printk() {
		// TODO Auto-generated method stub
		System.out.println(" from bean + configuration :->  name is :" + this.name + " and surname is " + this.surname );
		
	}
}
