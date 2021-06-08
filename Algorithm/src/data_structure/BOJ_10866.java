package data_structure;

import java.util.*;
import java.io.*;

/*
 * น้มุ 10866 ตฆ
 */

class BOJ_10866 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        LinkedList<Integer> deq = new LinkedList<Integer>();
        LinkedList<Integer>[] graph = new LinkedList[3];
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            String command = br.readLine();
            
            switch(command) {
                case "size":
                    bw.write(deq.size()+"\n");
                    break;
                    
                case "empty":
                    if(deq.isEmpty())
                        bw.write(1+"\n");
                    else
                        bw.write(0+"\n");
                    break;
                    
                case "pop_front":
                    if(!deq.isEmpty())
                        bw.write(deq.remove(0)+"\n");
                    else
                        bw.write(-1+"\n");
                    break;
                    
                case "pop_back":
                    if(!deq.isEmpty())
                        bw.write(deq.remove(deq.size()-1)+"\n");
                    else 
                        bw.write(-1+"\n");
                    break;
                    
                case "front":
                    if(!deq.isEmpty())
                        bw.write(deq.get(0)+"\n");
                    else
                        bw.write(-1+"\n");
                    break;
                    
                case "back":
                    if(!deq.isEmpty())
                        bw.write(deq.get(deq.size()-1)+"\n");
                    else
                        bw.write(-1+"\n");
                    break;
                    
                default:
                    StringTokenizer st = new StringTokenizer(command);
                    String push_dir = st.nextToken();
                    int data = Integer.parseInt(st.nextToken());
                    
                    if(push_dir.equals("push_front"))
                        deq.addFirst(data);
                    else
                    	deq.addLast(data);
                    
            }
        }
        
        bw.flush();
        
        br.close();
        bw.close();
        
        
    }
}
