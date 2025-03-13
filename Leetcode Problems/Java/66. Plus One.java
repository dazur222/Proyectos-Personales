class Solution {
    public int[] plusOne(int[] digits) {
        
         int res = 0;
          digits[digits.length - 1] = digits[digits.length - 1] + 1;
          
          for(int i = digits.length-1  ; i > -1 ; i--){
              
              digits[i] += res;
              res = 0;
              
              if(digits[i] == 10){
                  digits[i] = 0;
                  res = 1;
              }
              
          }
          
          
          if(digits[0] == 0){
              
                int[] digits2 = new int[digits.length+1];

                for(int i = 0 ; i < digits.length ; i++){
                digits2[i+1] = digits[i];
                }
                
                digits2[0] = 1;
          
                return digits2;
              
            }
        
       
          return digits;
          
        
        
    }
}