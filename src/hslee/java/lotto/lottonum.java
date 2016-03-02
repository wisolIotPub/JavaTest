package hslee.java.lotto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class lottonum {
	// ArrayList<Integer> totalNum;
	public lottonum() {
		makeNum(45);
		pickupNumPrint(makeNum(45), 6);
	}

	private void pickupNumPrint(ArrayList<Integer> pToatalNum, int pPickupNum) {
		ArrayList<Integer> tnum = (ArrayList<Integer>) pToatalNum.clone();
		ArrayList<ArrayList<Integer>> afterNum = new ArrayList<ArrayList<Integer>>();

		final int totalSetCnt = 10;
		int remainCnt;

		for (int j = 0; j < 3; j++) {
			Collections.shuffle(tnum);
		}

//		System.out.println(tnum.toString());
		int i = 0;
		while (true) {
			if (tnum.size() >= pPickupNum) {
				afterNum.add(new ArrayList<Integer>(tnum.subList(0, pPickupNum)));
				tnum.removeAll(afterNum.get(i));
			} else {
				final int remainNum = pPickupNum - tnum.size();
				afterNum.add(new ArrayList<Integer>(tnum));

				for (int ii = 0; ii < remainNum; ii++) {
					afterNum.get(afterNum.size() - 1).add(afterNum.get(ii).get(pPickupNum-1));
				}

				break;
			}
			i++;
		}
		remainCnt = totalSetCnt - afterNum.size();
		for (i = 0; i < remainCnt; i++) {
			ArrayList<Integer> tArray=new ArrayList<Integer>();
			for(int j=0;j<pPickupNum;j++){
				tArray.add(afterNum.get(j).get(i));
			}
			afterNum.add(tArray);
		}

		for (ArrayList<Integer> setNum : afterNum) {
			Collections.sort(setNum);
			System.out.println(setNum.toString());
		}

		saveResult(makeDir("d:\\lotto"), afterNum);
	}

	private ArrayList<Integer> makeNum(int pTotal) {
		ArrayList<Integer> totalNum = new ArrayList<Integer>();

		for (int i = 0; i < pTotal; i++) {
			totalNum.add(i + 1);
		}
		return totalNum;
	}
	
	private File makeDir(String path) {
		File pFile = null;

		pFile = new File(path);
		if (pFile.exists()) {
			System.out.println("folder is exist");
		} else {
			pFile.mkdirs();
		}

		return pFile;
	}
	private void saveResult(File pPathFile,ArrayList<ArrayList<Integer>> result){
		String resultString="";
		for (ArrayList<Integer> setNum : result) {
			Collections.sort(setNum);
			resultString+=setNum.toString()+"\r\n";
		}
		try {
			FileWriter fw = new FileWriter(new File(pPathFile, "lotto.txt"));
			fw.write(resultString);
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new lottonum();

	}

}
