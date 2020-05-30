package SimonSays;

public class SequenceListener extends Thread {
	private View view;
	private float level;
	public int[] generated; // generated sequence
	private SequenceGenerator in;
	public SequenceListener(SequenceGenerator in, View view) {
		this.in=in;
		this.view=view;
		if(view.hard)
			generated=in.generateSequence(this.view.sequenceInput.length);
		else
			generated=in.easySequence();
		this.level=1f;
	}
	
	@Override
	public void run() {
		while(true) {		
			System.out.print("");//necessary for the thread to be running 
			if(this.view.sequenceInput[this.view.reset.length-1] != 5) {
				this.view.pause();
				if(Utils.areEqual(this.generated, this.view.sequenceInput)) {
					level++;
					in.changeDelay((int) ((1f/level)*1000));
					
					view.changeTitle("Correct");
					Utils.delay(1000);
				}
				else {
					view.changeTitle("Incorrect");
					Utils.delay(1000);
					view.changeTitle("Game Over");
					Utils.delay(1000);
					System.exit(0);
				}

				this.view.sequenceInput = Utils.increase(this.view.sequenceInput);
				this.view.reset=Utils.increase(this.view.reset);
				Utils.delay(500);
				view.changeTitle("Simon Says");
				
				if(view.hard)
					generated=in.generateSequence(this.view.sequenceInput.length);
				else
					generated=in.easySequence();
				
			}
			
		}
		
	}//run method

	
}
