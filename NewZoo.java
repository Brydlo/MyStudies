package Zookeeper;

import java.util.Scanner;



public class NewZoo {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String camel = """
                    Switching on the camera in the camel habitat...
                     ___.-''''-.
                    /___  @    |
                    ',,,,.     |         _.'''''''._
                         '     |        /           \\
                         |     \\    _.-'             \\
                         |      '.-'                  '-.
                         |                               ',
                         |                                '',
                          ',,-,                           ':;
                               ',,| ;,,                 ,' ;;
                                  ! ; !'',,,',',,,,'!  ;   ;:
                                 : ;  ! !       ! ! ;  ;   :;
                                 ; ;   ! !      ! !  ; ;   ;,
                                ; ;    ! !     ! !   ; ;
                                ; ;    ! !    ! !     ; ;
                               ;,,      !,!   !,!     ;,;
                               /_I      L_I   L_I     /_I
                    Look at that! Our little camel is sunbathing!""";

            String lion = """
                    Switching on the camera in the lion habitat...
                                                                   ,w.
                                                                 ,YWMMw  ,M  ,
                                            _.---.._   __..---._.'MMMMMw,wMWmW,
                                       _.-""        '''           YP"WMMMMMMMMMb,
                                    .-' __.'                   .'     MMMMW^WMMMM;
                        _,        .'.-'"; `,       /`     .--""      :MMM[==MWMW^;
                     ,mM^"     ,-'.'   /   ;      ;      /   ,       MMMMb_wMW"  @\\
                    ,MM:.    .'.-'   .'     ;     `\\    ;     `,     MMMMMMMW `"=./`-,
                    WMMm__,-'.'     /      _.\\      F'''-+,,   ;_,_.dMMMMMMMM[,_ / `=_}
                    "^MP__.-'    ,-' _.--""   `-,   ;       \\  ; ;MMMMMMMMMMW^``; __|
                               /   .'            ; ;         )  )`{  \\ `"^W^`,   \\  :
                              /  .'             /  (       .'  /     Ww._     `.  `"
                             /  Y,              `,  `-,=,_{   ;      MMMP`""-,  `-._.-,
                            (--, )                `,_ / `) \\/"")      ^"      `-, -;"\\:
                    The lion is roaring!""";

            String deer = """
                    Switching on the camera in the deer habitat...
                       /|       |\\
                    `__\\       //__'
                       ||      ||
                     \\__`\\     |'__/
                       `_\\   //_'
                       _.,:---;,._
                       \\_:     :_/
                         |@. .@|
                         |     |
                         ,\\.-./ \\
                         ;;`-'   `---__________-----.-.
                         ;;;                         \\_\\
                         ';;;                         |
                          ;    |                      ;
                           \\   \\     \\        |      /
                            \\_, \\    /        \\     |\\
                              |';|  |,,,,,,,,/ \\    \\ \\_
                              |  |  |           \\   /   |
                              \\  \\  |           |  / \\  |
                               | || |           | |   | |
                               | || |           | |   | |
                               | || |           | |   | |
                               |_||_|           |_|   |_|
                              /_//_/           /_/   /_/
                    Our 'Bambi' looks hungry. Let's go to feed it!""";

            String goose = """
                    Switching on the camera in the goose habitat...
                                
                                                        _
                                                    ,-"" "".
                                                  ,'  ____  `.
                                                ,'  ,'    `.  `._
                       (`.         _..--.._   ,'  ,'        \\    \\
                      (`-.\\    .-""        ""'   /          (  d _b
                     (`._  `-"" ,._             (            `-(   \\
                     <_  `     (  <`<            \\              `-._\\
                      <`-       (__< <           :
                       (__        (_<_<          ;
                        `------------------------------------------
                    The goose is staring intently at you... Maybe it's time to change the channel?""";

            String bat = """
                    Switching on the camera in the bat habitat...
                    _________________               _________________
                     ~-.              \\  |\\___/|  /              .-~
                         ~-.           \\ / o o \\ /           .-~
                            >           \\  W  //           <
                           /             /~---~\\             \\
                          /_            |       |            _\\
                             ~-.        |       |        .-~
                                ;        \\     /        i
                               /___      /\\   /\\      ___\\
                                    ~-. /  \\_/  \\ .-~
                                       V         V
                    This bat looks like it's doing fine.""";

            String rabbit = """
                    Switching on the camera in the rabbit habitat...
                             ,
                            /|      __
                           / |   ,-~ /
                          Y :|  //  /
                          | jj /( .^
                          >-"~"-v"
                         /       Y
                        jo  o    |
                       ( ~T~     j
                        >._-' _./
                       /   "~"  |
                      Y     _,  |
                     /| ;-"~ _  l
                    / l/ ,-"~    \\
                    \\//\\/      .- \\
                     Y        /    Y
                     l       I     !
                     ]\\      _\\    /"\\
                    (" ~----( ~   Y.  )
                    It looks like we will soon have more rabbits!""";

            String[] watch = new String[]{camel, lion, deer, goose, bat, rabbit};
            int choose = 0;
            System.out.println("""
                        Do you want to see:
                        ----------------------
                        1. Camel - 0.
                        2. Lion - 1.
                        3. Deer - 2.
                        4. Goose - 3.
                        5. Bat - 4.
                        6. Rabbit - 5.
                        7. To quit - "exit".
                        """);

            System.out.print("Please enter the number of the habitat you would like to view: ");
            while (sc.hasNextInt()) {
                choose = sc.nextInt();
                switch (choose) {
                    case 0:
                        System.out.println(watch[0]);
                        System.out.print("Please enter the number of the habitat you would like to view: ");
                        break;
                        case 1:
                        System.out.println(watch[1]);
                        System.out.print("Please enter the number of the habitat you would like to view: ");
                        break;
                    case 2:
                        System.out.println(watch[2]);
                        System.out.print("Please enter the number of the habitat you would like to view: ");
                        break;
                    case 3:
                        System.out.println(watch[3]);
                        System.out.print("Please enter the number of the habitat you would like to view: ");
                        break;
                    case 4:
                        System.out.println(watch[4]);
                        System.out.print("Please enter the number of the habitat you would like to view: ");
                        break;
                    case 5:
                        System.out.println(watch[5]);
                        System.out.print("Please enter the number of the habitat you would like to view: ");
                        break;
                    default:
                        System.out.println("You choose wrong number try again");
                        System.out.print("Please enter the number of the habitat you would like to view: ");
                        break;
                }
            }
            System.out.println("See you later!");
        }
}
