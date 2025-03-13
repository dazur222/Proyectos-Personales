char* removeOccurrences(char* s, char* part) {
 
    int i;
    int has = 0;
    
    for(i = 0 ; s[i] ; i++);
    int sLen = i;

    for(i = 0 ; part[i] ; i++);
    int pLen = i;

    for(i = 0 ; i < sLen ; i++){

        if(s[i] == part[0]){
            int j;
            for(j = 0; j < pLen ; j++){
                if(s[i+j] != part[j]){
                    has = 0;
                    break;
                }
                has = 1;
            }
            if(has){
        
                int m = sLen - (i + pLen);
                for(j = 0 ; j < sLen - (i + pLen )    ; j++){
                    s[i+j] = s[  i+pLen+j ];
                }
                int n = i + (  sLen - (i + pLen) );
                s[n] = '\0';


                removeOccurrences(s,part);
            }
    }
    }
    
    return s;

}