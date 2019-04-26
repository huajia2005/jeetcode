package thexhc.algorithm;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
 *  S 中每个字符代表了一种你拥有的石头的类型，
 *  你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。
 * 字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 */

/**
 * @author thexhc
 * @version 1.0
 * @Date 2019/4/26 9:40
 */
public class numJewelsInStones {
    public static void main(String[] args) {
        numJewelsInStones jas=new numJewelsInStones();
        int a=jas.numJewelsInStones("aA","Abojda");
        System.out.println(a);
    }

    /**
     * @author thexhc
     * @version 1.0.0
     * @Date 2019/4/26 9:40
     */
    public  int numJewelsInStones(String J, String S) {
        char[] jc=J.toCharArray();
        char[] sc=S.toCharArray();
        int index=0;
        for(int i=0;i<jc.length;i++){
            for (int j = 0; j <sc.length ; j++) {
                if(jc[i]==sc[j]){
                    index++;
                }
            }
        }
        return index;
    }


    /**
     * @author thexhc
     * @version 2.0.0
     * @Date 2019/4/26 10:40
     */
    public  int numJewelsInStones2(String J, String S) {
        int count=0;
        for (int i = 0; i <J.length() ; i++) {
            for (int j = 0; j <S.length(); j++) {
                if(J.charAt(i)==S.charAt(j)){
                     count++;
                }
            }
        }
        return count;
    }
}
