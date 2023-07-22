//public class SnakkesagligPerson extends Thread
public class SnakkesagligPerson extends Thread {
	  private String navn;
	  private int ventetid;

	  public SnakkesagligPerson(String n, int t)
	  {
	    navn = n;
	    ventetid = t;
	  }

	  public void run()
	  {
	    for (int i=0; i<5; i++)
	    {
	      System.out.println(navn+": bla bla bla "+i);
	      try {  Thread.sleep(ventetid); } catch (Exception e) {} // vent lidt
	    }
	  }
	

}
