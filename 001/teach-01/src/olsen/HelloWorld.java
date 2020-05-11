package olsen;

public class HelloWorld {

    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }

    public static void main(String[] args) {
	    HelloWorld hello = new HelloWorld();
	    hello.sayHello("Bob");
    }


}
