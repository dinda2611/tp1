import java.util.Scanner;

public class BurhanQuest {

    private static final String BANNER = 
        "  ____             _                 ____                      _   \n" +
        " | __ ) _   _ _ __| |__   __ _ _ __ / __ \\ _   _  ___  ___  __| |_ \n" +
        " |  _ \\| | | | '__| '_ \\ / _` | '_ \\| |  | | | | |/ _ \\/ __|/ _` | | \n" +
        " | |_) | |_| | |  | | | | (_| | | | | |__| | |_| |  __/\\__ \\ (_| |_| \n" +
        " |____/ \\__,_|_|  |_| |_|\\__,_|_| |_|\\___\\_\\\\__,_|\\___||___/\\__,_(_) ";

    private static final String STUDENT_NAME = "Dinda Dinanti"; 
    private static final String STUDENT_ID = "2306245440";   

    // Penanda atribut
    private static final char NAME_IDENTIFIER = '!';
    private static final char STATUS_IDENTIFIER = '@';
    private static final char EXP_IDENTIFIER = '#';

    // Atribut khusus quest
    private static final char REWARD_IDENTIFIER = '$';
    private static final char DESC_IDENTIFIER = '%';
    private static final char DIFFICULTY_IDENTIFIER = '^';

    // Atribut khusus pengembara
    private static final char LEVEL_IDENTIFIER = '$';

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // --- SUB-TASK 1: MENAMPILKAN PESAN PEMBUKA ---
        System.out.println(BANNER);
        System.out.println("Selamat datang di BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
        System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");

        // --- SUB-TASK 2: SEEDING DATA ---
        int questCount = 0;
        int travelerCount = 0;

        // Input jumlah quest dengan validasi
        while (true) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: ");
            String in = input.nextLine().trim();
            try {
                questCount = Integer.parseInt(in);
                if (questCount >= 0) break;
            } catch (NumberFormatException e) {}
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
        }
        
        // Input jumlah pengembara dengan validasi
        while (true) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String in = input.nextLine().trim();
            try {
                travelerCount = Integer.parseInt(in);
                if (travelerCount >= 0) break;
            } catch (NumberFormatException e) {}
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
        }
        System.out.println();

        // --- INPUT DATA QUEST ---
        String questData = "";
        System.out.println("Mulai memasukkan data quest.");
        for (int i = 0; i < questCount; i++) {
            System.out.println("Data Quest ke-" + (i + 1) + ":");

            String name;
            while (true) {
                System.out.print("Nama: ");
                name = input.nextLine().trim();
                if (name.matches("^[a-zA-Z0-9 ]+$")) break;
                System.out.println("Input tidak valid. Nama hanya boleh karakter alfanumerik dan spasi.");
            }

            String desc;
            while (true) {
                System.out.print("Deskripsi: ");
                desc = input.nextLine().trim();
                if (desc.matches("^[a-zA-Z0-9 ]+$")) break;
                System.out.println("Input tidak valid. Deskripsi hanya boleh karakter alfanumerik dan spasi.");
            }

            int reward;
            while (true) {
                System.out.print("Reward: ");
                try {
                    reward = Integer.parseInt(input.nextLine().trim());
                    if (reward >= 0) break;
                } catch (NumberFormatException e) {}
                System.out.println("Input tidak valid. Reward harus berupa bilangan bulat nonnegatif.");
            }

            int bonusExp;
            while (true) {
                System.out.print("Bonus exp: ");
                try {
                    bonusExp = Integer.parseInt(input.nextLine().trim());
                    if (bonusExp >= 0) break;
                } catch (NumberFormatException e) {}
                System.out.println("Input tidak valid. Bonus exp harus berupa bilangan bulat nonnegatif.");
            }

            String difficulty;
            while (true) {
                System.out.print("Tingkat kesulitan: ");
                difficulty = input.nextLine().trim().toLowerCase();
                if (difficulty.equals("mudah") || difficulty.equals("menengah") || difficulty.equals("sulit")) break;
                System.out.println("Input tidak valid. Input hanya boleh mudah, menengah, atau sulit.");
            }

            // Simpan data dalam format String dengan identifier
            questData += NAME_IDENTIFIER + name + STATUS_IDENTIFIER + "tersedia" + 
                         EXP_IDENTIFIER + bonusExp + REWARD_IDENTIFIER + reward + 
                         DESC_IDENTIFIER + desc + DIFFICULTY_IDENTIFIER + difficulty + "|";
        }
        System.out.println();

        // --- INPUT DATA PENGEMBARA ---
        String travelerData = "";
        System.out.println("Mulai memasukkan data pengembara.");
        for (int i = 0; i < travelerCount; i++) {
            System.out.println("Data Pengembara ke-" + (i + 1) + ":");

            String tName;
            while (true) {
                System.out.print("Nama: ");
                tName = input.nextLine().trim();
                if (tName.matches("^[a-zA-Z0-9 ]+$")) break;
                System.out.println("Input tidak valid. Nama hanya boleh karakter alfanumerik dan spasi.");
            }

            // Pengembara biasanya mulai dari level 1 dan exp 0
            travelerData += NAME_IDENTIFIER + tName + LEVEL_IDENTIFIER + "1" + EXP_IDENTIFIER + "0" + "|";
        }
        System.out.println("Data berhasil dimasukkan.");
        System.out.println();

        // --- MENU UTAMA (Placeholder untuk Sub-Task berikutnya) ---
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Keluar"); // Disederhanakan untuk contoh
            System.out.print("Masukkan pilihan: ");
            String choice = input.nextLine().trim();
            if (choice.equals("1")) {
                running = false;
            } else {
                System.out.println("Fitur belum diimplementasikan.");
            }
        }

        // --- PESAN PENUTUP ---
        System.out.println("Terima kasih telah menggunakan BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
        System.out.println(BANNER);
    }
}