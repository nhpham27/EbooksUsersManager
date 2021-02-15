/*
 * Test AITictactoe class 
 * Test NextState class
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

class TestClasses {

	AITictactoe game;
	
	
	@Test
	void testAITictactoeConstructor() {
		AITictactoe game = new AITictactoe("Expert", "Expert", 1000);
		assertEquals("Expert", game.xLevel);
		assertEquals("Expert", game.oLevel);
		assertEquals(1000, game.delay);
	}
	
	// Test AITictatoe class
	@Test
	void testSwitchBoard() {
		AITictactoe game = new AITictactoe("Expert", "Expert", 1000);
		assertEquals("X X X O O O X X X", game.switchBoard("O O O X X X O O O"));
	}
	
	@Test
	void testSwitchBoard2() {
		AITictactoe game = new AITictactoe("Expert", "Expert", 1000);
		assertEquals("X b b O b b O b b", game.switchBoard("O b b X b b X b b"));
	}
	
	@Test
	void testEvaluateWinning() {
		AITictactoe game = new AITictactoe("Expert", "Expert", 1000);
		assertEquals(true, game.evaluateWinning("XXXbbbbbb", 'X'));
		assertEquals(true, game.evaluateWinning("bbbXXXbbb", 'X'));
		assertEquals(true, game.evaluateWinning("bbbbbbXXX", 'X'));
		assertEquals(true, game.evaluateWinning("XbbbXbbbX", 'X'));
		assertEquals(true, game.evaluateWinning("bbXbXbXbb", 'X'));
	}
	
	@Test
	void testEvaluateWinning2() {
		AITictactoe game = new AITictactoe("Expert", "Expert", 1000);
		assertEquals(true, game.evaluateWinning("OOObbbbbb", 'O'));
		assertEquals(true, game.evaluateWinning("bbbOOObbb", 'O'));
		assertEquals(true, game.evaluateWinning("bbbbbbOOO", 'O'));
		assertEquals(true, game.evaluateWinning("ObbbObbbO", 'O'));
		assertEquals(true, game.evaluateWinning("bbObObObb", 'O'));
	}
	
	@Test
	void testPlay() {
		AITictactoe game = new AITictactoe("Expert", "Expert", 0);
		float count = 0;
		for(int i = 0; i < 20; i++) {
			game.play(data->{});
			if(game.getWhoWon() == "Draw")
				count++;
		}
		
		assertEquals(true, count/20.0>0.9);
	}
	
	@Test
	void testPlay2() {
		AITictactoe game = new AITictactoe("Novice", "Expert", 0);
		float count = 0;
		for(int i = 0; i < 20; i++) {
			game.play(data->{});
			if(game.getWhoWon() == "O")
				count++;
		}
		
		assertEquals(true, count/20.0>0.8);
	}
	
	@Test
	void testPlay3() {
		AITictactoe game = new AITictactoe("Expert", "Novice", 0);
		float count = 0;
		for(int i = 0; i < 20; i++) {
			game.play(data->{});
			if(game.getWhoWon() == "X")
				count++;
		}
		
		assertEquals(true, count/20.0>0.8);
	}
	
	// Test NextState class
	@Test
	void testNextStateConstructor() {
		NextState next = new NextState("b b b b b b b b b", "Expert", 0);
		assertNotEquals(null, next.ai);
		assertEquals(0, next.delay);
		assertEquals("Expert", next.level);
	}
	
	@Test
	void testNextStateCall() {
		ExecutorService ex = Executors.newSingleThreadExecutor();
		Future<String> future = ex.submit(
									new NextState("b b b b b b b b b", "Expert", 0));
		String str;
		try {
			str = future.get();
			assertEquals(18, str.length());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ex.shutdown();
	}
	
}
