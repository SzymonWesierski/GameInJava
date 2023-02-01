package utilz;

public class Constants {

    public static class PlayerConstants{
        public static final int IDLE = 0;
        public static final int ATTACK = 23;
        public static final int DYING = 19;
        public static final int JUMP = 15;
        public static final int HURT =  16;
        public static final int RUNNING = 9;

        public static int GetSpriteAmount(int player_action){
            return switch (player_action) {
                case IDLE -> 8;
                case ATTACK -> 27;
                case HURT -> 18;
                case JUMP -> 15;
                case DYING -> 22;
                case RUNNING -> 14;
                default -> 1;
            };
        }
    }
}
