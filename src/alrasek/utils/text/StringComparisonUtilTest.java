package alrasek.utils.text;
import org.junit.Assert;
import org.junit.Test;

public class StringComparisonUtilTest {

	@Test
	public void testComparisonAddNewWord(){
		String newInstance= "Chcecie bajki oto byla bajka. Byla sobie pchla szachrajka";
		String oldInstance= "Chcecie bajki oto bajka. Byla sobie pchla szachrajka";
		String expected = "Chcecie bajki oto [<added>]byla [</added>]bajka. Byla sobie pchla szachrajka ";
		
		String result= StringComparisonUtil.getComparisonString(oldInstance, newInstance);
		System.out.println("testComparisonAddNewWord: " + result);
		Assert.assertEquals(result, expected);
	}

	@Test
	public void testComparisonDeleteWord(){
		String newInstance= "Chcecie bajki Byla sobie pchla szachrajka";
		String oldInstance= "Chcecie bajki oto bajka. Byla sobie pchla szachrajka";
		String expected = "Chcecie bajki [<deleted>]oto bajka. [</deleted>]Byla sobie pchla szachrajka ";
						  
		String result= StringComparisonUtil.getComparisonString(oldInstance, newInstance);
		System.out.println("testComparisonDeleteWord: " + result);
		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void testComparisonDeleteWord2(){
		String newInstance= "Chcecie bajki. Byla sobie pchla szachrajka";
		String oldInstance= "Chcecie bajki oto bajka. Byla sobie pchla szachrajka";
		String expected = "Chcecie [<added>]bajki. [</added>][<deleted>]bajki oto bajka. [</deleted>]Byla sobie pchla szachrajka ";
						  
		String result= StringComparisonUtil.getComparisonString(oldInstance, newInstance);
		System.out.println("testComparisonDeleteWord2: " + result);
		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void testComparisonChangeValue(){
		String newInstance= "Chcecie bajki. Byla sobie pchla szachrajka. A czynsz wynosil 35 zl. ";
		String oldInstance= "Chcecie bajki. Byla sobie pchla szachrajka. A czynsz wynosil 55 zl. ";
		String expected = "Chcecie bajki. Byla sobie pchla szachrajka. A czynsz wynosil [<added>]35 [</added>][<deleted>]55 [</deleted>]zl. ";
						  
		String result= StringComparisonUtil.getComparisonString(oldInstance, newInstance);
		System.out.println("testComparisonChangeValue: " + result);
		Assert.assertEquals(result, expected);
	}
}
