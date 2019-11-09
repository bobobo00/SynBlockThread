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
			System.out.println(this.getName()+"�˻������");
		}
		synchronized(account) {
			if(account.money-this.drawing<0) {
				System.out.println(this.getName()+"�˻�����");
				return;
			}
			account.money-=this.drawing;
			this.packet+=this.drawing;
			System.out.println(this.getName()+"������Ǯ���е�Ǯ��"+this.packet);
			System.out.println(this.getName()+"������"+account.name+":�˻���� "+account.money);
		}
		
	}
	
}