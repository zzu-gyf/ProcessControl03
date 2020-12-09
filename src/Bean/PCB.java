package Bean;

/**
 * @program: ProcessControl03
 * @description:PCB进程控制块，存放进程信息
 * @author: GYF
 * @create: 2020-12-08 21:53
 */
public class PCB {
    private int id;//进程标识符
    private String name;//进程名称
    private int memory;//进程占用内存空间
    private int times;//进程运行时间片
    private String state;//进程状态:C创建状态，R就绪状态，B阻塞状态，P执行状态，E终止状态；
    private int io;//进程是否需要申请io设备	0--不需要，1--需要
    private int priority;//进程优先级

    public PCB(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        if (memory <= 0){
            this.memory = 0;
        }else {
            this.memory = memory;
        }
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        if (times <= 0){
            this.times = 0;
        }else {
            this.times = times;
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIo() {
        return io;
    }

    public void setIo(int io) {
        this.io = io;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority <= 0){
            this.priority = 0;
        }else{
            this.priority = priority;
        }
    }

}
