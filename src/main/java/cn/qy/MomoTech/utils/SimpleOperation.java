package cn.qy.MomoTech.utils;

import io.github.thebusybiscuit.slimefun4.core.machines.MachineOperation;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.NotImplementedException;

public class SimpleOperation implements MachineOperation {
    int total;
    int now;
    public SimpleOperation(int total) {
        this.total = total;
        this.now = 0;
    }
    public void addRealProgress(int i) {
        this.now += i;
    }

    @Override
    public void addProgress(int i) throws NotImplementedException {
        throw new NotImplementedException("不要瞎即把加速!");
    }

    @Override
    public int getProgress() {
        return this.now;
    }

    @Override
    public int getTotalTicks() {
        return this.total;
    }
}
