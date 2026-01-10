package in.ashokit.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	
	//focus on final 
	private final IChip chip;
	
//	public Robot() {
//		// TODO Auto-generated constructor stub
//	}
	
	public Robot(IChip chip) {
		this.chip = chip;
	}
	
//	public void setRobo(IChip chip) {
//		this.chip = chip;
//	}

	public void doWork() {

		System.out.println("Injected :: " + chip.getClass().getName());

		boolean status = chip.process();

		if (status) {
			System.out.println("Robot is working...");
		} else {
			System.out.println("Robot is having fault...");
		}
	}

}
