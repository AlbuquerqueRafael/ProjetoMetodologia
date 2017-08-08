package shellsort;

public class ShellSort {
	
	public void shellSort(double[] nums) {
	    int h = 1;
	    int n = nums.length;
	    
	    while(h < n) {
	            h = h * 3 + 1;
	    }
	    
	    h = h / 3;
	    double c;
	    int j;
	    
	    while (h > 0) {
	        for (int i = h; i < n; i++) {
	            c = nums[i];
	            j = i;
	            while (j >= h && nums[j - h] > c) {
	                nums[j] = nums[j - h];
	                j = j - h;
	            }
	            nums[j] = c;
	        }
	        h = h / 2;
	    }
	}
}
