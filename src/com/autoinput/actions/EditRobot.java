package com.autoinput.actions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EditRobot extends Robot implements KeyListener {

	boolean lockOn = false;
	
	public EditRobot() throws AWTException {
		super();
	}
	
	public void moveMouse(int x, int y) {
		while(lockOn) {
			System.out.println("LOCK");
		}
		mouseMove(x, y);
		delay(100);
	}
	
	public void doubleClickMouse() {
		while(lockOn) {
			System.out.println("LOCK");
		}
		mousePress(InputEvent.BUTTON1_MASK);
		mouseRelease(InputEvent.BUTTON1_MASK);
		mousePress(InputEvent.BUTTON1_MASK);
		mouseRelease(InputEvent.BUTTON1_MASK);
		delay(100);
	}
	
	public void clickMouse() {
		while(lockOn) {
			System.out.println("LOCK");
		}
		mousePress(InputEvent.BUTTON1_MASK);
		mouseRelease(InputEvent.BUTTON1_MASK);
		delay(100);
	}
	
	public void down(int repeat) {
		for(int i = 0; i < repeat; i++) {
			down();
		}
		delay(100);
	}
	
	public void down() {
		while(lockOn) {
			System.out.println("LOCK");
		}
		keyPress(KeyEvent.VK_DOWN);
		keyRelease(KeyEvent.VK_DOWN);
		delay(100);
	}
	
	public void up() {
		while(lockOn) {
			System.out.println("LOCK");
		}
		keyPress(KeyEvent.VK_UP);
		keyRelease(KeyEvent.VK_UP);
		delay(100);
	}
	
	public void selectAll() {
		while(lockOn) {
			System.out.println("LOCK");
		}
		keyPress(KeyEvent.VK_CONTROL);
		keyPress(KeyEvent.VK_A);
		keyRelease(KeyEvent.VK_A);
		keyRelease(KeyEvent.VK_CONTROL);
		delay(100);
	}
	
	public void pressDelete() {
		while(lockOn) {
			System.out.println("LOCK");
		}
		keyPress(KeyEvent.VK_DELETE);
		keyRelease(KeyEvent.VK_DELETE);
		delay(100);
	}
	
	public void pressEnter() {
		while(lockOn) {
			System.out.println("LOCK");
		}
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);
		delay(100);
	}
	
	public void pressTab() {
		while(lockOn) {
			System.out.println("LOCK");
		}
		keyPress(KeyEvent.VK_TAB);
		keyRelease(KeyEvent.VK_TAB);
		delay(100);
	}
	
	public void keyInput(String input) {
		while(lockOn) {
			System.out.println("LOCK");
		}
		for(char c : input.toCharArray()) {
			if (Character.isUpperCase(c)) {
	            keyPress(KeyEvent.VK_SHIFT);
	        }
	        keyPress(Character.toUpperCase(c));
	        keyRelease(Character.toUpperCase(c));

	        if (Character.isUpperCase(c)) {
	            keyRelease(KeyEvent.VK_SHIFT);
	        }
		    delay(50);
	    }
	    delay(100);
	}
	
	public void doSearchAndSelectBoxWithContains(String input) {
		moveMouse(558, 268);
		clickMouse();
		selectAll();
		pressDelete();
		keyInput(input);
		pressEnter();
		delay(500);
		moveMouse(508, 354);
		clickMouse();
		clickMouse();
		moveMouse(1049, 691);
		clickMouse();
	}
	
	public void doSearchAndSelectBox(String input) {
		moveMouse(558, 268);
		clickMouse();
		selectAll();
		pressDelete();
		keyInput(input);
		pressEnter();
		delay(500);
		moveMouse(519, 271);
		clickMouse();
		down();
		pressEnter();
		moveMouse(764, 366);
		clickMouse();
		down();
		pressEnter();
		moveMouse(1117, 639);
		clickMouse();
		delay(100);
		moveMouse(508, 354);
		clickMouse();
		clickMouse();
//		moveMouse(1049, 691);
//		clickMouse();
	}
	
	public void selectColour(Long r, Long g, Long b, int x, int y) {
		moveMouse(x, y);
		clickMouse();
		moveMouse(730, 548);
		clickMouse();
		selectAll();
		pressDelete();
		keyInput(String.valueOf(r));
		moveMouse(730, 578);
		clickMouse();
		selectAll();
		pressDelete();
		keyInput(String.valueOf(g));
		moveMouse(730, 608);
		clickMouse();
		selectAll();
		pressDelete();
		keyInput(String.valueOf(b));
		moveMouse(865, 640);
		clickMouse();
		delay(50);
	}
	
	public void doTextSelection(Long r1, Long g1, Long b1, Long r2, Long g2, Long b2, Long r3, Long g3, Long b3) {
		moveMouse(1546, 542);
		clickMouse();
		down();
		down();
		down();
		pressEnter();
		selectColour(r1, g1, b1, 985, 652);
		selectColour(r2, g2, b2, 985, 682);
		selectColour(r3, g3, b3, 985, 712);
	}
	
	public void doIconSelection(Long r1, Long g1, Long b1, Long r2, Long g2, Long b2, Long r3, Long g3, Long b3) {
		moveMouse(1546, 542);
		clickMouse();
		down();
		down();
		pressEnter();
		selectColour(r1, g1, b1, 985, 652);
		selectColour(r2, g2, b2, 985, 682);
		selectColour(r3, g3, b3, 985, 712);
	}
	
	public void doShirtSelection(Long type, Long r1, Long g1, Long b1, Long r2, Long g2, Long b2, Long r3, Long g3, Long b3) {
		moveMouse(1546, 542);
		delay(50);
		clickMouse();
		delay(50);
		down();
		delay(50);
		pressEnter();
		delay(50);
		moveMouse(1533, 658);
		delay(50);
		clickMouse();
		delay(50);
		int r4 = (int) Math.floor((type) / 8);
		int c4 = (int) ((type-1) % 7);
		int x4 = 495;
		int y4 = 195;
		moveMouse(x4+(100*c4), y4+(75*r4));
		clickMouse();
		moveMouse(1065, 791);
		clickMouse();
		selectColour(r1,g1,b1, 981, 686);
		selectColour(r2,g2,b2, 981, 716);
		selectColour(r3,g3,b3, 981, 746);
	}
	
	public void doShortsSelection(Long type, Long r1, Long g1, Long b1, Long r2, Long g2, Long b2, Long r3, Long g3, Long b3) {
		moveMouse(1546, 542);
		clickMouse();
		down();
		down();
		down();
		down();
		pressEnter();
		moveMouse(1533, 658);
		clickMouse();
		int r4 = (int) (type % 2)-1;
		int c4 = (int) Math.floor(type / 8);
		int x4 = 495;
		int y4 = 193;
		moveMouse(x4+(100*c4), y4+(75*r4));
		clickMouse();
		moveMouse(1065, 791);
		clickMouse();
		selectColour(r1,g1,b1, 981, 686);
		selectColour(r2,g2,b2, 981, 716);
		selectColour(r3,g3,b3, 981, 746);
	}
	
	public void doSocksSelection(Long type, Long r1, Long g1, Long b1, Long r2, Long g2, Long b2, Long r3, Long g3, Long b3) {
		moveMouse(1546, 542);
		clickMouse();
		down();
		down();
		down();
		down();
		down();
		pressEnter();
		moveMouse(1533, 658);
		clickMouse();
		int r4 = 0;
		int c4 = 0;
		if(type < 8) {
			r4 = 0;
			c4 = type.intValue();
		} else {
			r4 = (int) (type % 3)-1;
			c4 = (int) (Math.floor(type / 8));
		}
		int x4 = 496;
		int y4 = 195;
		moveMouse(x4+(100*c4), y4+(80*r4));
		clickMouse();
		moveMouse(1065, 791);
		clickMouse();
		selectColour(r1,g1,b1, 981, 686);
		selectColour(r2,g2,b2, 981, 716);
		selectColour(r3,g3,b3, 981, 746);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_NUM_LOCK) {
			lockOn = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_NUM_LOCK) {
			lockOn = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
