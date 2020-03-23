package linklist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode node1 = new HeroNode(1,"luo");
        HeroNode node2 = new HeroNode(2,"hou");
        HeroNode node3 = new HeroNode(5,"hou");
        HeroNode node4= new HeroNode(3,"hou");
        HeroNode node5= new HeroNode(3,"hou111");
        SingleLinkedList list = new SingleLinkedList();
        list.add(node1);
        list.add(node2);
        list.addByOrder(node3);
        list.addByOrder(node4);
        list.updateNode(node5);
        list.delNode(1);
        list.delNode(2);
        list.delNode(3);
        list.delNode(6);
        list.showLinked();
    }
}
class SingleLinkedList{
    //初始化头节点
    private HeroNode head = new HeroNode(0,"");
    public  void add(HeroNode node){
        HeroNode temp = head;
        while(true){
            if(temp.next==null){
                break;
            }else {
                temp = temp.next;
            }
        }
        temp.next = node;
    }
    public void addByOrder(HeroNode node){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no>node.no){
                break;
            }else if(temp.next.no==node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag==true){
            System.out.println("编号重复");
        }else{
            HeroNode temp2 = temp.next;
            temp.next=node;
            node.next =temp2;
        }

    }
    //修改节点
    public void updateNode(HeroNode newHeroNode){
        //判断是否为空
        HeroNode temp = head;
        if(temp.next==null){
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        while (true){
            if(temp.next.no==newHeroNode.no){
                flag = true;
                break;
            }else{
                temp = temp.next;
            }
        }
        if(flag){
            temp.next.name= newHeroNode.name;
        }else{
            System.out.println("不存在该节点");
        }
    }
    public void delNode(int no){
        boolean flag = false;
        HeroNode temp = head;
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no==no){
                flag = true;
                break;
            }
            temp= temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("链表不存在，无法删除");
        }
    }
    public void showLinked(){
        //遍历链表
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (true){
            if(temp.next==null){
                break;
            }
            System.out.println(temp.next.toString());
            temp=temp.next;
        }

    }
}

class HeroNode{
    public int no;
    public String name;
    public HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
