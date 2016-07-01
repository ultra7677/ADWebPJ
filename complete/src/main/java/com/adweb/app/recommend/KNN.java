package com.adweb.app.recommend;

public class KNN {
	static int userNum = 4;
	static int itemNum = 6;
	
	//计算两个用户间的cosin相似度
	public double calculateSim(int[][] rating,int userA, int userB){
		double sim = 0;
		double above = 0;
		double belowA = 0;
		double belowB = 0;
		
		for (int j=1; j<=6; j++){
			if(rating[userA][j] != 0 && rating[userB][j] != 0){
				above += rating[userA][j] * rating[userB][j];
				belowA += rating[userA][j] * rating[userA][j];
				belowB += rating[userB][j] * rating[userB][j];
			}
		}
		
		if (belowA == 0 && belowB == 0) return -1;
		
		return above/(Math.sqrt(belowA)*Math.sqrt(belowB));
	}
	
	public double[] recommendForUser(int[][] rating,int userId){
		double[] predictRating = new double[10];
		int[] count = new int[10];
		
		for (int j = 1; j<=6; j++) count[j] = 0;
		
		for(int i=1; i<=4; i++){
			for(int j=1; j<=6; j++)
				System.out.print(rating[i][j] + " ");
			System.out.println();
		}
		
	//	System.out.println(calculateSim(rating,3,1));
	//	System.out.println(calculateSim(rating,3,2));
	//	System.out.println(calculateSim(rating,3,4));
		
		for(int j=1; j<=6; j++)
			if(rating[userId][j] == 0){	
				for(int i=1;i<=4;i++)
					if (i != userId && rating[i][j] != 0 && calculateSim(rating,userId,i)>0){
						// 根据相似度预测该用户对itemJ的打分
						predictRating[j] += rating[i][j] * calculateSim(rating,userId,i);
						count[j] ++;
					}
			}
		
	    for(int j=1;j <= 6; j++)
	    	if(count[j] != 0){
	    		predictRating[j] = predictRating[j]/count[j];
	    	}
	    return predictRating;
	}	
}
