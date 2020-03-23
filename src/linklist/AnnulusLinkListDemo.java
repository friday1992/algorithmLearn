package linklist;

public class AnnulusLinkListDemo {
    public static void main(String[] args) {
        AnnulusLinkeList list = new AnnulusLinkeList();
        list.add(5);
        list.list();
    }
}
class AnnulusLinkeList{
    //创建一个first节点
    private Boy firstBoy = null;
    //加
    public void add(int num){
        if(num<2){
            System.out.println("数字小于等于1");
            return;
        }
        //辅助指针
        Boy curBoy = null;
        //使用for循环
        for(int i = 1;i<=num;i++){
            Boy boy  = new Boy(i);
                if(i==1){
                    firstBoy = boy;
                    firstBoy.setNest(firstBoy);
                    curBoy = firstBoy;
                }else{
                    curBoy.setNest(boy);
                    boy.setNest(firstBoy);
                    curBoy = boy;
                }
        }

    }
    //遍历环形链表
    public void list(){
        if(firstBoy == null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = firstBoy;
        while (true){
            System.out.printf("编号 %d\n",curBoy.getNo());
            if(curBoy.getNest() == firstBoy){
                System.out.println("遍历完成");
                break;
            }
            curBoy = curBoy.getNest();
        }
    }
    public  void countBoy(int startnum,int countnum,int num){
        if(firstBoy ==null||num<1||startnum>num){
            System.out.println("参数有误");
        }
    }
}
class Boy{
    private int no;
    private Boy nest;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNest() {
        return nest;
    }

    public void setNest(Boy nest) {
        this.nest = nest;
    }
}