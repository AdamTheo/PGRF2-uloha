package Projekt;

import Projekt.global.LwjglWindow;
import Projekt.Renderer;

public class App {

	public static void main(String[] args) {
		new LwjglWindow(new Renderer(), false);
	}

}
