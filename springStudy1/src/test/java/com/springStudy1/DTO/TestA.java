package com.springStudy1.DTO;

public class TestA { //TestA에서 TestB를 사용하겠다
    private TestB tb;
	private TestC tc;
	
	public void makeObject2(TestC tc) { // 매개변수 TestC tc를 외부에서 만들어서 내부로 가져오는 형태로 가져오기 때문에 
		// public void makeObject2(TestC tc) 이거 한개면 된다.
		//약한 결합
		this.tc=tc;
	}
    
    
	public void makeObject1() {
		//강한 결합
		this.tb= new TestB();
		
	}
	public void makeObject1(int num, String name) {
		this.tb = new TestB(num,name);
	}
	public void makeObject1 (int num) {
		this.tb =new TestB(num);
	}
	
}
