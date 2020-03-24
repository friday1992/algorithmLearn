package linklist;

public class AnnulusLinkListDemo {
    public static void main(String[] args) {
        AnnulusLinkeList list = new AnnulusLinkeList();
        list.add(5);
        list.list();
        list.countBoy(1,2,5);
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
        Boy help = firstBoy;
        //help指向最后一个节点
        while (true){
            if(help.getNest() == firstBoy){
                break;
            }
            help = help.getNest();
        }
//        报数前，先让help,first移动k-1次
        for(int j= 0;j<startnum-1;j++){
            firstBoy = firstBoy.getNest();
            help = help.getNest();
        }
        //开始报数
        while (true){
            if(help == firstBoy){
                System.out.println("只有一个人啦");
                System.out.println(firstBoy.getNo());
                break;
            }
            for(int j= 0;j<countnum-1;j++){
                firstBoy = firstBoy.getNest();
                help = help.getNest();
            }
            System.out.printf("出圈 %d \n",firstBoy.getNo());
            //指向下一个人
            firstBoy = firstBoy.getNest();
            help.setNest(firstBoy);
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