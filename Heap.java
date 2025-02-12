public class Heap {
	
	Thing arr[];
	//Heap constructor taking as input the number of optios for autocorrect
	public Heap(int k){
		arr=new Thing[k+1];
		this.arr[0]=new Thing("CurrentSize",0);
		for(int i=1;i<=k;i++)
			this.arr[i]=new Thing("",-1);

	}
	//Thing inner class to represent the autocorrecting options with their corisponding importance 
	public class Thing{
		String word;
		int importance;
		
		public Thing(String word,int importance){
			this.word=word;
			this.importance=importance;
		}

	}

	/*Standard Percolate down method that puts an element that violates the heaps
	property to it's correct positon*/
	public static void PercolateDown(Thing A[], int n, int i) {
	    Thing temp = A[i]; // Store the element to be moved down
	    int j;
	    while (2 * i <= n) { // 1-based indexing
	        j = 2 * i; // Left child
	        if (j + 1 <= n && A[j + 1].importance < A[j].importance) {
	            j++; // Right child is smaller
	        }
	        if (temp.importance > A[j].importance) {
	            A[i] = A[j];
	            i = j;
	        } else {
	            break;
	        }
	    }
	    A[i] = temp; // Place the original element in its correct position
	}

	//rearenges an array so that it qualifys as a heap
	 
	public static void BuildHeap(Thing A[], int n) {
		for (int i = n / 2; i > 0; i--)
		PercolateDown(A, n, i);
		}
	
	
	
	
		//method to display the heap as a trie
		public void displayHeapAsTree() {
			this.HeapSort();
			for(int i=1;i<arr.length;i++){
				if(arr[i].importance!=-1)
				// System.out.printf ("%s [%d]\n",arr[i].word,arr[i].importance);
					System.out.println(arr[i].word);
			}
		}
		//method that locates if a word is already inside the heap so we don't insert duplicates
		public boolean stringExists(String word) {
		    for (int i = 1; i <= this.arr[0].importance; i++) { 
		        if (arr[i].word.equals(word)) {
		            return true;
		        }
		    }
		    return false;
		}
	
	public void insert(Thing thing){
		if(stringExists(thing.word))//if the word to be inserted already exists return
			return;
		
		if(this.arr[0].importance<this.arr.length-1){//when the elements that are currently inside are <k
			
			int index = this.arr[0].importance + 1;
			while (index > 1 && this.arr[(index / 2)].importance >thing.importance){
			this.arr[index].importance=this.arr[(index / 2)].importance;
			this.arr[index].word=this.arr[(index / 2)].word;

			index = index / 2;
		}
		this.arr[index]=thing;
		this.arr[0].importance++;
		
		}
		//logic for when the heap is already full algorithm to compare the root with the element to be inserted
		else if(this.arr[0].importance==arr.length-1) {
			if(thing.importance>arr[1].importance){
				arr[1]=thing;
				PercolateDown(this.arr,this.arr[0].importance,1);
				
			}
		}
	}
		
	public void HeapSort() {
	    Thing swap = new Thing("empty", 0); 
		int p =  this.arr[0].importance;

	    for(int i=p;i>1;i--)
	    {
	    	swap=arr[1];
	    	arr[1]=arr[i];
	    	arr[i]=swap;
	        this.arr[0].importance--;
	    	PercolateDown(this.arr,i-1,1);
	    }
	}
	public boolean isEmpty()
	{
		return this.arr[0]==null;
	}
	public static void main(String[] args) {
	    // Initialize the Heap with capacity for 5 elements
	    int k = 5;
	    Heap heap = new Heap(k);

	    // Step 2: Insert 50 non-random words with varying importance
	    String[] words = {
	        "Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew",
	        "IndianFig", "Jackfruit", "Kiwi", "Lemon", "Mango", "Nectarine", "Orange",
	        "Papaya", "Quince", "Raspberry", "Strawberry", "Tangerine", "UgliFruit",
	        "Vanilla", "Watermelon", "Xigua", "YellowPassionFruit", "Zucchini",
	        "Apricot", "Blackberry", "Cranberry", "Dragonfruit", "Eggfruit", "Feijoa",
	        "Guava", "Hackberry", "IceCreamBean", "Jujube", "Kumquat", "Lychee",
	        "Mulberry", "Nance", "Olive", "Peach", "Quandong", "Rambutan", "Salak",
	        "Tamarind", "Umbu", "Voavanga", "WaxApple", "YamBean", "Ziziphus"
	    };

	    // Assign importance values (simple pattern for testing)
	    for (int i = 0; i < 50; i++) {
	        heap.insert(heap.new Thing(words[i],i + 1)); // Importance = index + 1
	    }

	    // Step 3: Display the contents of the heap
	    System.out.println("Heap contents after 50 insertions:");
	    heap.HeapSort();
	    heap.displayHeapAsTree();
	}

}
