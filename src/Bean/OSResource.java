package Bean;

/**
 * @program: ProcessControl03
 * @description: 系统资源类，存放系统资源
 * @author: GYF
 * @create: 2020-12-08 21:53
 */
public class OSResource {
    private static int OSMemory;//操作系统内存大小
    private static int MaxOsMemory;//操作系统最大内存大小
    private static int cpuState;//cpu状态：小于0 程序异常 0:无法为其他进程分配 大于0:可以分配
    private static int ioState;//io设备状态：0--未占用，1--正在使用

    public static int getMaxOsMemory() {
        return MaxOsMemory;
    }

    public static void setMaxOsMemory(int maxOsMemory) {
        MaxOsMemory = maxOsMemory;
    }

    public static int getOSMemory() {
        return OSMemory;
    }

    public static void setOSMemory(int OSMemory) {
        OSResource.OSMemory = OSMemory;
    }

    public static int getCpuState() {
        return cpuState;
    }

    public static void setCpuState(int cpuState) {
        OSResource.cpuState = cpuState;
    }

    public static int getIoState() {
        return ioState;
    }

    public static void setIoState(int ioState) {
        OSResource.ioState = ioState;
    }

    public static void OSInit(){
        setOSMemory(20);
        setMaxOsMemory(20);
        setCpuState(1);
        setIoState(0);
    }
}
