/**
 * 
 * calls the bat file and imports necessary files like unit vector, dwm and weight vector. The result you get
 * is SOMVioewer GUI
 * 
 */

package som.components;

import som.notifier.SOMNotifier;
import som.observer.SOMObserver;

public class SOMGUIViewer extends SOMObserver{

	public SOMGUIViewer(SOMNotifier notifier) {
		this.notifier = notifier;
		this.notifier.attach(this);
	}

	@Override
	public void update() {
		try{

			String command = "cmd /c start  runSOM.bat";
			Runtime.getRuntime().exec(command);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
