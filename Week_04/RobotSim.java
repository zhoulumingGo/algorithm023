class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] direx = {0,1,0,-1};
        int[] direy = {1,0,-1,0};
        int curx = 0, cury = 0;
        int curdire = 0;
        int comLen = commands.length;
        int ans = 0;
        // 使用Set保存障碍物位置
        Set<Pair<Integer,Integer>> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleSet.add(new Pair<>(obstacles[i][0], obstacles[i][1]));
        }
        for (int i = 0; i <comLen; i++) {
            if (commands[i] == -1) {
                // -1：向右转 90 度
                curdire = (curdire+1) % 4;
            }
            else if (commands[i] == -2) {
                // -2：向左转 90 度
                curdire = (curdire+3) % 4;
            }
            else {
                for (int j = 0; j < commands[i]; j++) {
                    // 走一步，并判断是否遇到了障碍物
                    int nx = curx+direx[curdire];
                    int ny = cury+direy[curdire];
                    // 当前坐标不是障碍点，计算并与存储的最大欧式距离的平方做比较
                    if (!obstacleSet.contains(new Pair<>(nx,ny))) {
                        curx = nx;
                        cury = ny;
                        ans = Math.max(ans, curx*curx + cury*cury);
                    }
                    else {
                        // 是障碍点，只能等待下一个指令，跳出当前指令
                        break;
                    }
                }
            }
        }
        return ans;
    }
}