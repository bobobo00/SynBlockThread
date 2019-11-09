package SyThread;

public class SynBlockThread {
	public static void main(String[] args) {
		Account a=new Account("A",1000);
		Thread t1=new DrawingMoney(a,800,"aaa");
		Thread t2=new DrawingMoney(a,100,"bbb");
		t1.start();
		t2.start();
	}

}
class Account{
	 String name;
	 int money;
	public Account(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
}
class DrawingMoney extends Thread{
	private Account account;
	private int drawing;
	private int packet;
	public DrawingMoney(Account account, int drawing,String name) {
		super(name);
		this.account = account;
		this.drawing = drawing;
	}
	@Override
	public void run() {
		drawingmenoy();
	}
	public void drawingmenoy() {
		if(account.money<=0) {
			System.out.println(this.getName()+"账户无余额");
		}
		synchronized(account) {
			if(account.money-this.drawing<0) {
				System.out.println(this.getName()+"账户余额不足");
				return;
			}
			account.money-=this.drawing;
			this.packet+=this.drawing;
			System.out.println(this.getName()+"操作后：钱包中的钱："+this.packet);
			System.out.println(this.getName()+"操作后："+account.name+":账户余额 "+account.money);
		}
		
	}
	
}