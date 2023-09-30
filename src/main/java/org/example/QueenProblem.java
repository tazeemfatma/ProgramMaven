package org.example;

import java.util.List;

class QueenProblem {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        Integer tpr=null,tpc=null,
                btr=null, btc=null,
                ltr=null, ltc = null,
                rtr = null, rtc=null,
                tlr = null, tlc=null,
                trr = null, trc=null,
                blr = null, blc=null,
                brr = null, brc=null;
        int kr, kc;
        int moves =0;


        for(List<Integer> i : obstacles){
            kr=i.get(0); kc= i.get(1);
            if(kc == c_q ){ //column obstacle
                if(kr>r_q){ //top
                    if(tpr == null ){
                        tpr=kr; tpc=kc;
                    }
                    else if((kr-r_q) < (tpr- r_q)){
                        tpr=kr; tpc=kc;
                    }
                } else{ //bottom
                    if(btr == null){
                        btr=kr; btc=kc;
                    }
                    else if((r_q - kr) < (r_q-btr)){
                        btr=kr; btc=kc;
                    }
                }
            } else if(kr == r_q){//Row obstacles
                if(c_q > kc){ //left
                    if(ltr == null){
                        ltr= kr; ltc= kc;
                    }
                    else if(c_q-kc <  c_q-ltc )
                        ltr= kr; ltc= kc;
                }else{ //right
                    if(rtr == null){
                        rtr=kr;rtc=kc;
                    }
                    else if(kc-c_q < rtc-c_q)
                        rtr=kr;rtc=kc;;
                }
            }
            else if(Math.abs(r_q-kr)== Math.abs(c_q-kc)){
                if(kr >r_q && kc < c_q) { // top-left
                    if (tlr == null) {
                        tlr = kr;
                        tlc = kc;
                    } else if (kr - r_q < tlr - r_q){
                        tlr = kr; tlc=kc;
                    }
                }else if(r_q > kr && c_q < kc){//bottom-right
                    if(brr==null){
                        brr=kr; brc=kc;
                    }else if(r_q-kr < r_q-brr){
                        brr=kr; brc=kc;
                    }

                }else if(kr > r_q && kc > c_q){//top-right
                    if(trr==null){
                        trr=kr; trc=kc;
                    }else if(kr-r_q < trr-r_q){
                        trr=kr; trc=kc;
                    }

                }else if(r_q > kr && c_q > kc){//bottom-left
                    {
                        if(blr==null){
                            blr=kr; blc=kc;
                        }else if(r_q-kr < r_q-blr){
                            blr=kr; blc=kc;
                        }
                    }

                }

            }

        }

        if(tpr != null)
            moves+=tpr-r_q-1;
        else
            moves+= n-r_q;

        if(btr !=null)
            moves+= r_q-btr-1;
        else
            moves+= r_q-1;

        if(ltr !=null)
            moves+= c_q-ltc-1;
        else
            moves+= c_q-1;

        if(rtr != null)
            moves+= rtc-c_q-1;
        else
            moves+= n- c_q;

        if(tlr != null)
            moves+= tlr-r_q-1;
        else {
            moves += Math.min(n-r_q,c_q-1);
        }
        if(brr != null)
            moves+= r_q-brr-1;
        else
            moves+= Math.min(r_q-1,n-c_q);

        if(trr != null)
            moves+= trr-r_q-1;
        else {
            if(r_q> c_q)
                moves+= n-r_q;
            else
                moves+= n-c_q;
        }
        if(blr != null)
            moves+= r_q-blr-1;
        else {
            if(r_q < c_q)
                moves += r_q-1;
            else
                moves += c_q-1;
        }
        return moves;

    }

}
