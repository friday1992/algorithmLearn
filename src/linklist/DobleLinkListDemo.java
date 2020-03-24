package linklist;

/**
 * 双向链表
 */

public class DobleLinkListDemo {
    public static void main(String[] args) {
        HeroNode2 node1= new HeroNode2(1,"luo");
        HeroNode2 node2 = new HeroNode2(2,"hou");
        HeroNode2 node3 = new HeroNode2(5,"hou");
        HeroNode2 node4= new HeroNode2(3,"hou");
        HeroNode2 node5= new HeroNode2(3,"hou111");
        DoubleLinkList linkList = new DoubleLinkList();
        linkList.list();
        linkList.addEnd(node1);
        linkList.addEnd(node2);
        linkList.addEnd(node3);
        linkList.addEnd(node4);
        linkList.list();
        //修改
        linkList.update(node5);
        System.out.println("-------------------");
        linkList.list();
        //删除
        linkList.del(1);
        System.out.println("-------------------");
        linkList.list();
        //按序号添加
        linkList.addByOrder(0,node5);
        System.out.println("-------------------");
        linkList.list();
    }




}

class HeroNode2 {
    public int no;
    public String name;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向上一个节点



    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name +
                '}';
    }
}
class DoubleLinkList {
    //初始化一个头节点
    private HeroNode2 head = new HeroNode2(0,"头节点");
    //返回头节点111
    public HeroNode2 getHea(){
        return head;
    }
    //遍历
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //获取下一个next,用temp接收
        HeroNode2 temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
    //默认添加到最后
    public void addEnd(HeroNode2 node){
        //先找到链表的最后一个节点，用遍历
        if(head.next == null){
            head.next = node;
            node.pre = head;
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //把最后一个节点的next指向添加的节点,添加节点的pre添加temp
        temp.next = node;
        node.pre = temp;

    }
    //添加在编号后面
    public void addByOrder(int no,HeroNode2 node){
        if(head.next == null){
            System.out.println("链表为空,加到最后面");
            head.next = node;
            node.pre = head;
            return;
        }
        //遍历链表
        HeroNode2 temp = head;
        boolean flag = false;
        while(true){
            if(temp.next==null){
                break;
            }
            //比较
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if(flag){
            HeroNode2 temp2 =temp.next;
            temp.next = node;
            node.pre = temp;
            node.next = temp2;
            temp2.pre = node;
        }else{
            System.out.println("没有找到该编号");
        }
    }
    //修改一个节点的内容
    public void update(HeroNode2 node){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        Boolean flag = false; //用来表示是否找到该节点
        while (true){
            //表示节点是否已被遍历完成
            if(temp == null){
                break;
            }
            //对比要修改的节点
            if(temp.no==node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag = true){
            temp.name = node.name;
        }else{
            System.out.println("没有找到该节点");
        }
    }
    //删除节点
    public void del(int no){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        Boolean flag = false; //用来表示是否找到该节点
        while (true){
            //表示节点是否已被遍历完成
            if(temp == null){
                break;
            }
            //对比要修改的节点
            if(temp.no==no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            //如果是最后一个节点就不执行
            if(temp.next!=null) {
                temp.next.pre = temp.pre;
            }
        }else{

        }

    }
}
