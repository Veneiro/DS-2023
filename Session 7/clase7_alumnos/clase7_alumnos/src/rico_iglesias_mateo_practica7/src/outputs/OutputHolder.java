package outputs;

import java.util.ArrayList;
import java.util.List;

public class OutputHolder {
    
    List<Output> outputs = new ArrayList<Output>();

    public OutputHolder(Output ...outs){
        for (Output output : outs) {
            outputs.add(output);
        }
    }

    public void applyModifiers(){
        
    }

    public void copy(){
        
    }
}
