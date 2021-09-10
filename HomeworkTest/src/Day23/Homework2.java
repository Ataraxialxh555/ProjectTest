package Day23;

import java.util.Objects;
import java.util.Scanner;

/*

    第二题：（java软件工程师人生路上第一个小型项目。锻炼一下面向对象。）
        为某个酒店编写程序：酒店管理系统，模拟订房、退房、打印所有房间状态等功能。
        1、该系统的用户是：酒店前台。
        2、酒店使用一个二维数组来模拟。“Room[][] rooms;”
        3、酒店中的每一个房间应该是一个java对象：Room
        4、每一个房间Room应该有：房间编号、房间类型、房间是否空闲.
        5、系统应该对外提供的功能：
            可以预定房间：用户输入房间编号，订房。
            可以退房：用户输入房间编号，退房。
            可以查看所有房间的状态：用户输入某个指令应该可以查看所有房间状态。

 */
public class Homework2 {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("请输入正确的用户名和密码");
            return;
        }
        if("酒店前台".equals(args[0]) &&"123456".equals(args[1])){
            System.out.println("欢迎"+args[0]+"回来！！");
            System.out.println("请继续使用该系统！");
        }
        Hotel hotel = new Hotel();
        System.out.println("请认真阅读以下操作说明！");
        System.out.println("功能介绍：【0】：退出系统；【1】：查询酒店房间信息；【2】：预定房间；【3】：退房；");

        while(true) {
            Scanner s = new Scanner(System.in);
            System.out.print("请输入选择的操作：");
            int res = s.nextInt();
            if (res == 0) {
                System.out.println("欢迎再次使用本系统！！！");
                return;
            } else if (res == 1) {
                System.out.println("酒店所有房间状态信息如下：");
                hotel.printRooms();
            } else if (res == 2) {
                Scanner s2 = new Scanner(System.in);
                System.out.print("请输入预定的房间号码：");
                int roomId = s2.nextInt();
                hotel.bookRoom(roomId);
            } else if (res == 3) {
                Scanner s3 = new Scanner(System.in);
                System.out.print("请输入退房的房间号码：");
                int roomId1 = s3.nextInt();
                hotel.exitRoom(roomId1);
            } else {
                System.out.print("输入数字有误，请重新输入：");
            }
        }
    }
}
class Rooms {
    private int roomNum; //房间号
    private String roomType;    //房间类型
    private boolean isEmpty; //  房间状态 true:空闲 false: 占用

    public Rooms(int roomNum, String roomType, boolean isEmpty) {
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.isEmpty = isEmpty;
    }

    public Rooms() {
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomNum=" + roomNum +
                ", roomType='" + roomType + '\'' +
                ", isEmpty=" + (isEmpty? "空闲":"占用")+
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Rooms)) return false;
        Rooms rooms = (Rooms) o;
        return this.getRoomNum() == rooms.getRoomNum() ;
    }
}
class Hotel {
    private Rooms[][] rooms;

    public Hotel(Rooms[][] rooms) {
        this.rooms = rooms;
    }
//    赋初始值
    public Hotel() {
        this.rooms = new Rooms[3][10];
        for (int i = 0; i<rooms.length ; i++){
            for(int j = 0 ; j < rooms[i].length;j++){
                if(i == 0){
                    rooms[i][j] = new Rooms((i+1)*100 + j+1,"单人间",true);
                }else if (i == 1){
                    rooms[i][j] = new Rooms((i+1)*100 + j+1,"标准间",true);
                }else{
                    rooms[i][j] = new Rooms((i+1)*100 + j+1,"豪华套房",true);
                }
            }
        }
    }

    public Rooms[][] getRooms() {
        return rooms;
    }

    public void setRooms(Rooms[][] rooms) {
        this.rooms = rooms;
    }
    //打印酒店信息
    public void printRooms(){
        for (int i = 0; i < getRooms().length; i++) {
            for (int j = 0 ; j < getRooms()[i].length ; j++){
                System.out.print(getRooms()[i][j].toString());
            }
            System.out.println();
        }
    }
    //订房
    public void bookRoom(int roomNum){
        rooms[roomNum / 100 - 1 ][roomNum % 100 -1].setEmpty(false);
        System.out.println("已订房"+roomNum);
    }
    //退房
    public void exitRoom(int roomNum){
        rooms[roomNum / 100 - 1 ][roomNum % 100 -1].setEmpty(true);
        System.out.println("已退房"+roomNum);

    }
}