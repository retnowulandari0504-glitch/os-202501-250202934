import threading
import time

forks = [threading.Lock() for _ in range(5)]
room_controller= threading.Semaphore(4)

def philosopher_fixed(i):
    left = forks[i]
    right = forks[(i+1) % 5]

    while True:
        print(f"Filsuf {i} berpikir...")
        time.sleep(1)

        room_controller.acquire()
        print(f"Filsuf {i} mendapat izin masuk ruangan")

        try:
            left.acquire()
            print(f"Filsuf {i} berhasil ambil garpu kanan {(i+1) % 5}")

            print(f"Filsuf {i} sedang makan...")
            time.sleep(1)

        finally:
            left.release()
            right.release()
            print(f"Filsuf {i} selesai makan dan letakan garpu")

            room_controller.release()

    threads_fixed = []
    for i in range(5):
        t = threading.Thread(target=philosopher_fixed, args=(1,), daemon=True)
        threads_fixed.append(t)
        t.start()

    while True:
        time.sleep(1)