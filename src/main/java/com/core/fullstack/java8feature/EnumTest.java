import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum PracEnum {

	SMALL, MEDIUM, LARGE, EXTRALARGE;
	
	public String getSize() {
		switch(this) {
		  case SMALL:
		    return "small";
		  case MEDIUM:
		    return "medium";
		  case LARGE:
		    return "large";
		  case EXTRALARGE:
		    return "extra large";
	    default:
	      return null;
		}
	}
	
	public static void main(String[] args) {

		 System.out.println("The size of the pizza is 1" + PracEnum.SMALL.getSize());
		 System.out.println("The size of the pizza is 2 " + PracEnum.SMALL.compareTo(PracEnum.MEDIUM));
		 System.out.println("The size of the pizza is 3 " + PracEnum.SMALL.compareTo(PracEnum.MEDIUM));
		 System.out.println("The size of the pizza is 4 " + PracEnum.SMALL.toString());
		 System.out.println("The size of the pizza is 5 " +  PracEnum.valueOf(SMALL.toString()));
		 System.out.println("The size of the pizza is 6 " +  PracEnum.values().toString());
		 System.out.println("The size of the pizza is 7 " +  PracEnum.MEDIUM.ordinal());
    
		 PracEnum[] enumArray = PracEnum.values();
		 System.out.println("The size of the pizza is 8 " +  enumArray.toString());		
	}
}
