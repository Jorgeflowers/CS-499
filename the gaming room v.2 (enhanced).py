class GameManager:
    def __init__(self, game_file='games.txt'):
        self.games = []
        self.load_games(game_file)

    def load_games(self, game_file):
        try:
            with open(game_file, 'r') as f:
                self.games = [line.strip() for line in f if line.strip()]
        except FileNotFoundError:
            print(f"Error: {game_file} not found.")
            self.games = []

    def list_games(self):
        if not self.games:
            print("No games available.")
            return
        print("\nAvailable Games:")
        for i, game in enumerate(self.games, 1):
            print(f"{i}. {game}")

    def start_game(self, index):
        if 0 <= index < len(self.games):
            print(f"\nStarting {self.games[index]}... Enjoy!")
        else:
            print("Invalid game number.")


class GameRoomApp:
    def __init__(self):
        self.manager = GameManager()

    def run(self):
        print("Welcome to The Gaming Room (Enhanced Version)")
        while True:
            print("\nMain Menu:")
            print("1. View Available Games")
            print("2. Start a Game")
            print("3. Exit")

            choice = input("Enter your choice (1-3): ").strip()
            if choice == '1':
                self.manager.list_games()
            elif choice == '2':
                self.manager.list_games()
                try:
                    selection = int(input("Enter the number of the game to start: ")) - 1
                    self.manager.start_game(selection)
                except ValueError:
                    print("Please enter a valid number.")
            elif choice == '3':
                print("Exiting The Gaming Room. Goodbye!")
                break
            else:
                print("Invalid input. Please choose 1, 2, or 3.")


if __name__ == "__main__":
    app = GameRoomApp()
    app.run()
