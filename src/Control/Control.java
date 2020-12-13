package Control;

import Bean.OSResource;
import Bean.PCB;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ProcessControl03
 * @description: 进程控制的一些操作
 * @author: GYF
 * @create: 2020-12-08 21:54
 */
public class Control {

    public static List<PCB> c_List = new ArrayList<PCB>();    //创建进程表
    public static List<PCB> r_List = new ArrayList<PCB>();    //活动就绪进程表
    public static List<PCB> b_List = new ArrayList<PCB>();    //活动阻塞进程表
    public static List<PCB> p_List = new ArrayList<PCB>();    //执行进程表
    public static List<PCB> e_List = new ArrayList<PCB>();    //终止进程表
    public static List<PCB> s_r_List = new ArrayList<PCB>();   //静止就绪进程表
    public static List<PCB> s_b_List = new ArrayList<PCB>();   //静止阻塞进程表
    public static String OutPut = "";//输出
    public static boolean win_true = false;//为真，则显示id不合法
    private static int ii = 0;
    private static int m = 12;//测试分配内存
    private static boolean aBoolean=false;//判断分配cpu时是否跳出循环，为true则跳出



    /**
     * 删除list里的pcb项
     **/
    public static void DeletePcb(List<PCB> list, PCB pcb) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == pcb.getId()) {
                list.remove(i);
                break;
            }
        }
    }

    /**
     * 根据id和队列，取得该队列中id为id的pcb
     **/
    public static PCB SearchPCB(List<PCB> list, int id) {
        PCB pcb = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                pcb = list.get(i);
                break;
            }

        }
        return pcb;
    }

    /**
     * 创建
     * 申请PCB
     **/
    public static void RequestPCB(String name) {
        OutPut = "";
        int a = (int) ((Math.random() * 10) + 1);
        PCB pcb = new PCB(name);//设置进程名称
        pcb.setId(ii);
        ii = ii + 1;
//        System.out.println("进程" + pcb.getName() + "的pid为" + pcb.getId());
        OutPut = "进程" + pcb.getName() + "的pid为" + pcb.getId();
        pcb.setPriority(a);//设置进程优先级
        pcb.setTimes(5);//设置进程需要运行的时间
        pcb.setMemory(m);
        m = m - 2;
        c_List.add(pcb);//将创建好的进程加入创建进程表
//        System.out.println("进程" + pcb.getName() + "创建完毕，已加入创建队列，等待分配系统资源...");
        OutPut = OutPut + "\n" + "进程" + pcb.getName() + "创建完毕，已加入创建队列，等待分配系统资源...";
    }

    public static void RequestPCB1(String name, int mem, int time, int property) {
        OutPut = "";
        PCB pcb = new PCB(name);//设置进程名称
        pcb.setId(ii);
        ii = ii + 1;
//        System.out.println("进程" + pcb.getName() + "的pid为" + pcb.getId());
        OutPut = "进程" + pcb.getName() + "的pid为" + pcb.getId();
        pcb.setPriority(property);//设置进程优先级
        pcb.setTimes(time);//设置进程需要运行的时间
        pcb.setMemory(mem);
        c_List.add(pcb);//将创建好的进程加入创建进程表
//        System.out.println("进程" + pcb.getName() + "创建完毕，已加入创建队列，等待分配系统资源...");
        OutPut = OutPut + "\n" + "进程" + pcb.getName() + "创建完毕，已加入创建队列，等待分配系统资源...";
    }

    /**
     * 创建to静止就绪
     * c_List to s_r_List
     **/
    public static void CToS_C(PCB pcb) {
        s_r_List.add(pcb);
        DeletePcb(c_List, pcb);
        System.out.println(pcb.getName() + "已经放入静止就绪队列");

    }


    /**
     * 创建队列申请内存
     **/
//    public static void RequestMemory(int id) {
//        PCB pcb = null;
//        int i = 0;
//        //把获取创建队列里id为传入值的pcb
//        for (int j = 0; j < c_List.size(); j++) {
//            if (c_List.get(j).getId() == id) {
//                pcb = c_List.get(j);
//                c_List.remove(j);
//                i = j;
//                break;
//            }
//        }
//        int MaxOsMemory = OSResource.getMaxOsMemory();
//        int OsMemory = OSResource.getOSMemory();
//        //如果系统可用内存大于进程所需内存，则为其分配内存资源
//        /**
//         * 不完善！！！！！！！！！！！！！！！！！
//         * 如果pcb需要的内存大于系统最大内存则不分配并移出创建进程表
//         * 如果需要的内存小于系统可用内存，则分配,将创建进程里的pcb删除，就绪进程表放入此pcb
//         * 否则将该pcb保留在创建进程表中
//         * **/
//        if (pcb.getMemory() > MaxOsMemory) {
//            c_List.remove(i);
//            System.out.println(MaxOsMemory);
//            System.out.println("系统最大内存小于该进程，进程" + pcb.getName() + "永远无法获得内存...");
//        } else if (pcb.getMemory() <= OsMemory) {
//
//            OSResource.setOSMemory(OsMemory - pcb.getMemory());
//            System.out.println("进程" + pcb.getName() + "已分配内存空间：" + pcb.getMemory());
//            System.out.println("系统剩余内存空间：" + OSResource.getOSMemory());
//
//            //将进程从创建队列中移除，并将进程状态改为就绪状态，最后将进程加入到就绪队列中。
//            pcb.setState("R");
////            c_List.remove(i);
//            r_List.add(pcb);
//            System.out.println("进程" + pcb.getName() + "所需内存已分配完毕，加入就绪队列，等待运行...");
//
//        } else {
//            System.out.println("系统可用内存不足，进程" + pcb.getName() + "暂时无法获得内存...");
//        }
//    }
    public static void RequestMemory(PCB pcb) {

        int MaxOsMemory = OSResource.getMaxOsMemory();
        int OsMemory = OSResource.getOSMemory();
        //如果系统可用内存大于进程所需内存，则为其分配内存资源
        /**
         * 不完善！！！！！！！！！！！！！！！！！
         * 如果pcb需要的内存大于系统最大内存则不分配并移出创建进程表
         * 如果需要的内存小于系统可用内存，则分配,将创建进程里的pcb删除，就绪进程表放入此pcb
         * 否则将该pcb保留在创建进程表中
         * **/
        if (pcb.getMemory() > MaxOsMemory) {
            DeletePcb(c_List, pcb);
            System.out.println(MaxOsMemory);
//            System.out.println("系统最大内存小于该进程，进程" + pcb.getName() + "永远无法获得内存，已删除该进程...");
            OutPut = OutPut + "\n" + "系统最大内存小于该进程，进程" + pcb.getName() + "永远无法获得内存，已删除该进程...";
        } else if (pcb.getMemory() <= OsMemory) {
            OSResource.setOSMemory(OsMemory - pcb.getMemory());
//            System.out.println("进程" + pcb.getName() + "已分配内存空间：" + pcb.getMemory());
//            System.out.println("系统剩余内存空间：" + OSResource.getOSMemory());
            OutPut = OutPut + "\n" + "进程" + pcb.getName() + "已分配内存空间：" + pcb.getMemory() + "\n" + "系统剩余内存空间：" + OSResource.getOSMemory();

            if (SearchPCB(s_r_List, pcb.getId()) != null) {//说明pcb是静止就绪队列的，需要激活，放入活动就绪队列
                DeletePcb(s_r_List, pcb);
                r_List.add(pcb);
                pcb.setState("R");
                System.out.println("进程" + pcb.getName() + "所需内存已分配完毕,等待运行...");
                OutPut = OutPut + "\n" + "进程" + pcb.getName() + "所需内存已分配完毕,等待运行...";

            } else if (SearchPCB(s_b_List, pcb.getId()) != null) {//说明pcb是静止阻塞队列的，需要激活，放入活动就绪队列
                DeletePcb(s_b_List, pcb);
                b_List.add(pcb);
                pcb.setState("B");
                System.out.println("进程" + pcb.getName() + "所需内存已分配完毕,等待运行...");
                OutPut = OutPut + "\n" + "进程" + pcb.getName() + "所需内存已分配完毕,等待运行...";

            } else if (SearchPCB(c_List, pcb.getId()) != null) {
                DeletePcb(c_List, pcb);
                r_List.add(pcb);
                pcb.setState("R");
                System.out.println("进程" + pcb.getName() + "所需内存已分配完毕,等待运行...");
                OutPut = OutPut + "\n" + "进程" + pcb.getName() + "所需内存已分配完毕,等待运行...";

            } else {
                System.out.println("此进程无法申请内存");
                OutPut = OutPut + "\n" + "进程" + pcb.getName() + "无法申请内存";
            }
            //将进程从创建队列中移除，并将进程状态改为就绪状态，最后将进程加入到就绪队列中。
//            c_List.remove(i);
//            DeletePcb(c_List,pcb);
//            System.out.println(c_List.size());

        } else {
            if (SearchPCB(s_r_List, pcb.getId()) != null) {//说明pcb是静止就绪队列的，需要激活，放入活动就绪队列
                System.out.println("系统可用内存不足，进程" + pcb.getName() + "暂时无法获得内存...");
                OutPut = OutPut + "\n" + "系统可用内存不足，进程" + pcb.getName() + "暂时无法获得内存...";

            } else if (SearchPCB(s_b_List, pcb.getId()) != null) {//说明pcb是静止阻塞队列的，需要激活，放入活动就绪队列
                System.out.println("系统可用内存不足，进程" + pcb.getName() + "暂时无法获得内存...");
                OutPut = OutPut + "\n" + "系统可用内存不足，进程" + pcb.getName() + "暂时无法获得内存...";

            } else if (SearchPCB(c_List, pcb.getId()) != null) {
                CToS_C(pcb);
                System.out.println("系统可用内存不足，进程" + pcb.getName() + "暂时无法获得内存...");
                OutPut = OutPut + "\n" + "系统可用内存不足，进程" + pcb.getName() + "暂时无法获得内存...";

            } else {
                System.out.println("此进程无法申请内存");
                OutPut = OutPut + "\n" + "进程" + pcb.getName() + "无法申请内存";

            }

        }
    }

    /**
     * 释放内存
     **/
    public static void ReleaseMemory(int id) {
        PCB pcb1 = SearchPCB(r_List, id);
//        System.out.println(pcb1.getName() + " " + pcb1.getId());
        PCB pcb2 = SearchPCB(p_List, id);
//        System.out.println(pcb2.getName() + " " + pcb2.getId());
        PCB pcb3 = SearchPCB(b_List, id);
        if (pcb1 == null && pcb2 == null && pcb3 == null) {
            System.out.println();
            OutPut = OutPut + "\n" + "该pcb不在执行队列或就绪队列或活动阻塞队列，不占用内存";

        } else if (pcb1 != null) {
            System.out.println();
            OutPut = OutPut + "\n" + "就绪队列的进程，释放内存中******";

            OSResource.setOSMemory(OSResource.getOSMemory() + pcb1.getMemory());
            System.out.println();
            OutPut = OutPut + "\n" + "进程" + pcb1.getName() + "," + pcb1.getMemory() + "内存已释放。";

        } else if (pcb2 != null) {
            System.out.println();
            OutPut = OutPut + "\n" + "执行队列的进程，释放内存中******";

            OSResource.setOSMemory(OSResource.getOSMemory() + pcb2.getMemory());
            System.out.println();
            OutPut = OutPut + "\n" + "进程" + pcb2.getName() + "," + pcb2.getMemory() + "内存已释放。";

        } else if (pcb3 != null) {
            System.out.println();
            OutPut = OutPut + "\n" + "活动阻塞队列的进程，释放内存中******";

            OSResource.setOSMemory(OSResource.getOSMemory() + pcb3.getMemory());
            System.out.println();
            OutPut = OutPut + "\n" + "进程" + pcb3.getName() + "," + pcb3.getMemory() + "内存已释放。";


        }
    }


    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!有毛病
    //根据进程优先级，将就绪队列中的进程进行降序排序
    public static void sortReadList(List<PCB> list) {
        List<PCB> temp = new ArrayList<PCB>();
        int m = list.size();

        for (int i = 0; i < m; i++) {
            PCB tmp = null;
            int max = list.get(0).getPriority(), key = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getPriority() > max) {
                    max = list.get(j).getPriority();
                    key = j;
                }
            }
            tmp = list.get(key);
            list.remove(key);
            temp.add(tmp);
        }
        r_List = temp;
    }

    /**
     * 挂起1
     * 活动就绪to静止就绪
     * 释放内存
     **/
    public static void RtoS_P(PCB pcb) {
//        PCB pcb = SearchPCB(r_List, id);//就绪队列中的该id对应的pcb
        ReleaseMemory(pcb.getId());
        DeletePcb(r_List, pcb);//删除就绪队列中的pcb
        s_r_List.add(pcb);//放入静止就绪队列
        System.out.println();
        OutPut = OutPut + "\n" + "进程" + pcb.getName() + "已挂起，放入静止就绪队列中。" + pcb.getMemory() + "内存已释放。";
        pcb.setState("S_R");

    }

    /**
     * 挂起2
     * 执行to静止就绪
     * 释放内存
     * 释放cpu
     **/
    public static void PtoS_P(PCB pcb) {
//        PCB pcb = SearchPCB(p_List, id);//执行队列中的该id对应的pcb

        s_r_List.add(pcb);//放入静止就绪队列
        ReleaseMemory(pcb.getId());
        ReleaseCpu(pcb.getId());
        DeletePcb(p_List, pcb);//删除执行队列中的pcb
        System.out.println();
        OutPut = OutPut + "\n" + "进程" + pcb.getName() + "已挂起，放入静止就绪队列中" + pcb.getMemory() + "内存已释放，cpu已释放。";

//        System.out.println(OSResource.getOSMemory());
//        System.out.println("进程"+pcb.getName()+","+pcb.getMemory()+"内存已释放。");
        pcb.setState("S_R");


    }

    /**
     * 挂起3
     * 活动阻塞to静止阻塞
     * 释放内存
     **/
    public static void BtoS_B(PCB pcb) {
        ReleaseMemory(pcb.getId());
        DeletePcb(b_List, pcb);//删除活动阻塞队列中的pcb
        s_b_List.add(pcb);//放入静止阻塞队列
        System.out.println();
        OutPut = OutPut + "\n" + "进程" + pcb.getName() + "已挂起，放入静止阻塞队列中。" + pcb.getMemory() + "内存已释放。";
        //        System.out.println("进程"+pcb.getName()+","+pcb.getMemory()+"内存已释放。");
        pcb.setState("S_B");
    }


    public static void ccc(int id) {
        OutPut = "";
        PCB pcb1 = SearchPCB(p_List, id);
        PCB pcb2 = SearchPCB(r_List, id);
        PCB pcb3 = SearchPCB(b_List, id);

        if (pcb1 == null && pcb2 == null && pcb3 == null) {
            win_true = true;
            System.out.println();
            OutPut = OutPut + "\n" + "该pcb不在执行队列或就绪队列或活动阻塞队列，不能被挂起";

        } else if (pcb1 != null) {
            win_true = false;
            PtoS_P(pcb1);
        } else if (pcb2 != null) {
            win_true = false;
            RtoS_P(pcb2);
        } else if (pcb3 != null) {
            win_true = false;
            BtoS_B(pcb3);
        }
        sortReadList(r_List);

    }


    /**
     * 激活1
     * 静止就绪to活动就绪
     **/
    public static void S_PtoP(int id) {
//        PCB pcb = SearchPCB(s_r_List, id);//静止就绪队列中的该id对应的pcb
        PCB pcb1 = SearchPCB(s_r_List, id);
        PCB pcb2 = SearchPCB(s_b_List, id);
        if (pcb1 != null) {
            RequestMemory(pcb1);
        } else if (pcb2 != null) {
            RequestMemory(pcb2);
        }
//        RequestCpu(pcb.getId());
//        DeletePcb(s_r_List, pcb);//删除静止就绪队列中的pcb
//        r_List.add(pcb);//放入活动就绪队列
//        pcb.setState("R");
    }

    /**
     * 激活2
     * 静止阻塞to活动阻塞
     **/
    public static void ddd(int b) {
//        int b = Integer.parseInt(a);
        PCB pcb1 = SearchPCB(s_r_List, b);
        PCB pcb2 = SearchPCB(s_b_List, b);
        if (pcb1 == null && pcb2 == null) {
            win_true = true;
        } else {
            win_true = false;
            S_PtoP(b);
        }

        sortReadList(r_List);

    }

    /**
     * 请求IO
     **/
    public static void eee(int a) {
        OutPut = "";
        PCB pcb = SearchPCB(p_List, a);
        if (pcb == null) {
            win_true = true;
        } else {
            win_true = false;
            ReleaseCpu(a);
            OutPut = OutPut + "\n" + pcb.getName() + "占用的cpu已释放";
            DeletePcb(p_List, pcb);
            b_List.add(pcb);
            pcb.setState("B");
        }

    }

    /**
     * IO完成
     **/
    public static void fff(int a) {
        PCB pcb = SearchPCB(b_List, a);
        if (pcb == null) {
            win_true = true;
        } else {
            win_true = false;
            DeletePcb(b_List, pcb);
            r_List.add(pcb);
            OutPut=OutPut+"\n"+"进程"+pcb.getName()+"IO完成";
            sortReadList(r_List);
            pcb.setState("R");
        }
    }

    public static void ggg(int a) {
        PCB pcb = SearchPCB(s_b_List, a);
        if (pcb == null) {
            win_true = true;
        } else {
            win_true = false;
            DeletePcb(s_b_List, pcb);
            s_r_List.add(pcb);
            OutPut = OutPut+"\n"+"进程"+pcb.getName()+"已释放";
            pcb.setState("S_R");
        }
    }

    /**
     * 就绪队列申请cpu
     * 如果cpu状态<=0则等待，大于0则分配,进入执行队列，删除就绪队列
     **/
    public static void RequestCpu(int id) {
        aBoolean=false;
        PCB pcb = SearchPCB(r_List, id);
        int cpu_state = OSResource.getCpuState();
        if (cpu_state <= 0) {
            aBoolean=true;
            OutPut = OutPut + "\n" + "cpu在忙，进程" + pcb.getName() + "暂时无法申请到cpu，在就绪队列等待中";
//            System.out.println();
        } else {
            OSResource.setCpuState(cpu_state - 1);
            DeletePcb(r_List, pcb);//删除就绪队列的pcb
            p_List.add(pcb);//放入执行队列
//            r_List.remove(pcb);//删除就绪队列信息
            OutPut = OutPut + "\n" + "进程" + pcb.getName() + "申请cpu成功，已进入执行队列";
//                    System.out.println();
        }
    }

    /**
     * 释放cpu
     * 将该进程放入list
     **/
    public static void ReleaseCpu(int id) {
//        PCB pcb = p_List.get(0);
//        DeletePcb(list, pcb);
//        list.add(pcb);
        OSResource.setCpuState(OSResource.getCpuState() + 1);
    }

    /**
     * 一个进程运行n个时间片
     **/
    public static void RunTimes(int n) {

        while (!p_List.isEmpty()) {
            PCB pcb = p_List.get(0);
            int count = 0;
            while (pcb.getTimes() > 0) {
                pcb.setTimes(pcb.getTimes() - 1);
                System.out.println();
                OutPut = OutPut + "\n" + "进程" + pcb.getName() + "剩余执行时间为：" + pcb.getTimes();

                count++;
//                Thread.currentThread().sleep(1000);//假设一个时间片为1s
                if (count >= n)
                    break;
            }

//        PtoS_P(pcb.getId());
            //如果时间片小于等于0，删除执行队列的pcb，添加到终止队列，否则优先级-1放入就绪队列

            if (pcb.getState() == "S_R") {

            } else {
                if (pcb.getTimes() <= 0) {
                    e_List.add(pcb);
                    ReleaseMemory(pcb.getId());
                    ReleaseCpu(pcb.getId());
                    DeletePcb(p_List, pcb);
                    System.out.println();
                    OutPut = OutPut + "\n" + "进程" + pcb.getName() + "执行完成";

                } else {
                    pcb.setPriority(pcb.getPriority() - 1);
                    r_List.add(pcb);
                    DeletePcb(p_List, pcb);
                    ReleaseCpu(pcb.getId());
                    sortReadList(r_List);//每次放入新进程都要排序
                    System.out.println();
                    OutPut = OutPut + "\n" + "进程" + pcb.getName() + "时间片完成，优先级-1，放入就绪队列";

                }
            }
        }
    }

//    /**
//     * 请求io
//     **/
//    public static void RequestIO(int id) {
//        PCB pcb = p_List.get(0);
//    }

//    /**
//     * 释放io
//     **/
//    public static void ReleaseIO(int id) {
//
//    }

//    /**
//     * 强行终止
//     **/
//    public static void ForceEnd() {
//
//    }

    public static void aaa() {
        if (!c_List.isEmpty() || !r_List.isEmpty() || !b_List.isEmpty() || !p_List.isEmpty()) {

            for (int i = 0; i < r_List.size()+i; i++) {

                RequestCpu(r_List.get(0).getId());
                if (aBoolean)
                    break;
//                System.out.println("111");
            }
//                if (c_List.isEmpty() && r_List.isEmpty() && b_List.isEmpty() && p_List.isEmpty())
//                    break;
//            }
        }
    }

    public static void bbb() {
//        for (int i=0;i<p_List.size();i++){
        OutPut = "";
        RunTimes(OSResource.getRun());
//        }
    }

    public static void run() {
        if (!c_List.isEmpty() || !r_List.isEmpty() || !b_List.isEmpty() || !p_List.isEmpty()) {
            while (true) {
//                if (!b_List.isEmpty() && OSResource.getIoDevice() == 0 && SystemResource.getIoDevice() > 0) {
//                    recallPrs();
//                }
                //循环读取就绪队列
                for (int i = 0; i < r_List.size(); i++) {
                    //将就绪队列队首的进程（优先级最高的进程）移除，并加入执行队列
//                    p_List.add(r_List.get(0));
//                    r_List.remove(0);
                    //为该进程分配系统资源（若不需要系统资源，则向下执行）
//                    requestIO(p_List.get(0).getId());
//                    requestResource(p_List.get(0).getId());

                    System.out.println(r_List.get(0).getName());
                    System.out.println(r_List.get(0).getId());

                    RequestCpu(r_List.get(0).getId());

                    //                Thread thread = new Thread();
                    //使用三个for循环模拟进程的执行
//                for (int i1 = 0; i1 < 999999999; i1++) {
//                }
//                for (int i1 = 0; i1 < 999999999; i1++) {
//                }
//                for (int i1 = 0; i1 < 999999999; i1++) {
//                }
//                    System.out.println("进程" + p_List.get(0).getName() + "正在执行...");


//                    RunTimes(p_List.get(0), 3);


//                    S_PtoP(p_List.get(0).getId());

//                    PtoS_P(p_List.get(0).getId());
//                    PtoS_P(p_List.get(0).getId());
                    //执行完3个时间片后，进程优先级降低一级，且总运行时间减少3
//                    p_List.get(0).setPriority(p_List.get(0).getPriority() - 1);
//                    p_List.get(0).setTimes(p_List.get(0).getTimes() - 3);
//                    System.out.println("进程" + p_List.get(0).getName() + "剩余执行时间为：" + p_List.get(0).getTimes());
                    //执行完当前时间片后，释放系统资源
//                    releaseIO(p_List.get(0).getId());
//                    releaseRes(p_List.get(0).getId());
//                    ReleaseCpu(p_List.get(0).getId());
//                    if (p_List.get(0).getTimes() > 0) {
//                        r_List.add(p_List.get(0));
//                    } else {
//                        e_List.add(p_List.get(0));
//                    }
//                    p_List.remove(0);


                }
                //如果除终止进程表外其余表项全为空，则跳出循环
                if (c_List.isEmpty() && r_List.isEmpty() && b_List.isEmpty() && p_List.isEmpty())
                    break;
            }
        }
    }


    //初始化，默认分配
    public static void init() {

        OutPut = "";
        while (!c_List.isEmpty()) {
            RequestMemory(c_List.get(0));
        }
        sortReadList(r_List);
//        for (int i = 0; i < r_List.size(); i++) {
//            System.out.println(r_List.get(i).getName() + r_List.get(i).getId());
//        }
        OutPut = OutPut + "\n" + "进程按照优先级排列：";
        System.out.println("进程按照优先级排列：");
        for (int i = 0; i < r_List.size(); i++) {
            System.out.println("进程：" + r_List.get(i).getName() + "优先级为" + r_List.get(i).getPriority());
            OutPut = OutPut + "\n" + "进程：" + r_List.get(i).getName() + "优先级为" + r_List.get(i).getPriority();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        init();
        run();
        System.out.println(OSResource.getOSMemory());

    }

}
