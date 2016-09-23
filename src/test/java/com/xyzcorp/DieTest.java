package com.xyzcorp;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DieTest {

    //Simplest thing rolling a die....
    @Test
    public void testDefaultIs1() {
       Die die = new Die();  //Subject Under Test
       assertThat(die.getPips()).isEqualTo(1);
    }
    
    @Test
    public void testSimpleRollOf4() {
        //Stub - Test Double - Collaborator
        Random random = new Random() {
            @Override
            public int nextInt() {
                return 4;
            }
        };
        Die die = new Die(random);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(4);
    }

    @Test
    public void testSimpleRollOf6WithAMock() {
        //Mock - Test Double - Collaborator
        //1. Create the mock
    	    Random random = mock(Random.class);

    	    //2. Rehearse with the mock
    	    when(random.nextInt()).thenReturn(6);
        
    	    //3. Run the Test
        Die die = new Die(random);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(6);
    }
    
    @Test
    public void testSimpleRollOf6ThenA4WithAMock() {
        //Mock - Test Double - Collaborator
        //1. Create the mock
    	    Random random = mock(Random.class);

    	    //2. Rehearse with the mock
    	    when(random.nextInt()).thenReturn(6,2);
        
    	    //3. Run the Test
        Die die = new Die(random);
        Die rolledDie = die.roll().roll();
        assertThat(rolledDie.getPips()).isEqualTo(2);
    }

    @Test
    public void testStateOfPips() {
    	   Random random = mock(Random.class);
    	   //2. Rehearse with the mock
   	   when(random.nextInt()).thenReturn(6,2);
       
   	   //3. Run the Test
       Die firstRoll = new Die(random).roll();
       Die secondRoll = firstRoll.roll();
       assertThat(firstRoll.getPips()).isEqualTo(6);
       assertThat(secondRoll.getPips()).isEqualTo(2);
    }
    
    @Test
    public void testThatRandomIsNotNull() {
       try {
    	      new Die(null);
    	      fail("Should not be here");
       } catch (NullPointerException npe) {
    	      assertThat(npe).hasMessage("Random is null");
       }
    }
    
    public void testRollWithDefaultNoArgsConstruction() {
    	
    }
   
}





