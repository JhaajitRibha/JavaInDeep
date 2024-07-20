package CodingPractice.Interview;

public class I2 {
    public static void main(String[] args) {
        String data="a,b,c,z e,f,g,y i,j,k,x m,n,o,w q,r,s,p t,u,v,u";
        calculations (data);



//		output:
//		[[a, e, i, m, q],
//		 [b, f, j, n, r],
//		 [c, g, k, o, s]]
    }

    public static void calculations(String data) {

        char[] dataArr = data.toCharArray();

        String[] splittedData = data.split("\\s");

        //abc,e,f,g,i,j,k


        int row = splittedData[0].length();
        int col = splittedData.length;

        char[][] outputRes= new char[row][col];



        for(int j=0;j<col;j++){
            for(int i=0;i<row;i++){
                outputRes[i][j] = splittedData[j].charAt(i);
            }
        }

        for(int i=0;i<outputRes.length;i++){

            for(int j=0;j<outputRes[i].length;j++){
                if(outputRes[i][j]!=',') {
                    System.out.print(outputRes[i][j] + " ");
                }

            }


            System.out.println();
        }

    }

}


