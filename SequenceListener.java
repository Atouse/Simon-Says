package SimonSays;

public class SequenceListener extends Thread {
	private Screen view; 
	private float level; //level to determine the speed of the sequence shown
	public int[] generated; // generated sequence
	private SequenceGenerator in; //sequence generator
	private int[] ee;
	public SequenceListener(SequenceGenerator in, Screen view) {
		this.in=in;
		this.view=view;
		if(view.hard) //generates a hard sequence
			generated=in.generateSequence(this.view.sequenceInput.length);
		else //generates an easy sequence
			generated=in.easySequence();
		this.level=1f;
		ee=new int[] {ColourSquare.RED,ColourSquare.BLUE};
	}//Constructor
	
	@Override
	public void run() {
		while(true) {		
			System.out.print("");//necessary for the thread to be running 
			if(this.view.sequenceInput[this.view.reset.length-1] != 5) {//when the input sequence is filled
				this.view.pause();
				if(Utils.areEqual(this.generated, this.view.sequenceInput)) {//User gets it right
					if(view.hard)//increases the level
						level++;
					
					in.changeDelay((int) ((1f/level)*1000));//changes the delay at which the sequence is shown
					
					view.changeTitle("Correct");
					Utils.play("Correct");
					Utils.delay(1000);
				}
				else if(Utils.areEqual(this.view.sequenceInput, ee)) {
					view.changeTitle("Celebration Time");
					Utils.play("Celebration");
				}
				else {//User gets it wrong
					view.changeTitle("Incorrect");
					Utils.play("Wrong");
					Utils.delay(1000);
					view.changeTitle("Game Over");
					Utils.delay(1000);
					System.exit(0);
				}

				this.view.sequenceInput = Utils.increase(this.view.sequenceInput);//increases the generated sequence length
				this.view.reset=Utils.increase(this.view.reset);//increases the reset sequence length
				Utils.delay(500);
				view.changeTitle("Simon Says");
				
				if(view.hard) //generates a hard sequence
					generated=in.generateSequence(this.view.sequenceInput.length);
				else //generates an easy sequence
					generated=in.easySequence();
				
			}//if
			
		}//while
		
	}//run method

	
}
