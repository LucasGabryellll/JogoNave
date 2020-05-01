package app;

import controller.ControllerStage;
import view.WindowsContainer;

public class App {
	
	public static void main(String[] args) {
		
		WindowsContainer windowsContainer  = new WindowsContainer();
			
		ControllerStage controllerStage = new ControllerStage(windowsContainer.getWindowStage());
		
	}

}
