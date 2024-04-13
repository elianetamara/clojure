def initialize_jogo():
    return {
        'tabuleiro': initialize_tabuleiro(),
        'jogadores': ['X', 'O'],
        'jogador_atual': 0,
        'vitorias': {'X': 0, 'O': 0},
        'empates': 0
    }


def initialize_tabuleiro(tam=3):
    return [[' ' for _ in range(tam)] for _ in range(tam)]


def print_tabuleiro(tabuleiro):
    for row in tabuleiro:
        print(" | ".join(row))
        print("-" * 10)


def verifica_ganhador(tabuleiro):
    for row in tabuleiro:
        if row.count('X') == 3:
            return 'X'
        elif row.count('O') == 3:
            return 'O'

    for col in range(3):
        if tabuleiro[0][col] == tabuleiro[1][col] == tabuleiro[2][col] != ' ':
            return tabuleiro[0][col]

    if tabuleiro[0][0] == tabuleiro[1][1] == tabuleiro[2][2] != ' ':
        return tabuleiro[0][0]
    if tabuleiro[0][2] == tabuleiro[1][1] == tabuleiro[2][0] != ' ':
        return tabuleiro[0][2]

    return None


def is_tabuleiro_cheio(tabuleiro):
    for row in tabuleiro:
        if ' ' in row:
            return False
    return True


def update_tabuleiro(tabuleiro, jogador, posicao):
    row, col = posicao
    if tabuleiro[row][col] == ' ':
        new_tabuleiro = [row[:] for row in tabuleiro]
        new_tabuleiro[row][col] = jogador
        return new_tabuleiro
    else:
        return tabuleiro


def jogar_novamente():
    while True:
        novamente = input("Jogar novamente? (S/N): ").strip().upper()
        if novamente in ['S', 'N']:
            return novamente == 'S'
        else:
            print("Opção inválida. Por favor, escolha 'S' para sim ou 'N' para não.")


def entrada_valida(mensagem):
    while True:
        entrada = input(mensagem)
        if entrada.isdigit():
            valor = int(entrada)
            if 0 <= valor <= 2:
                return valor
            else:
                print("Por favor, digite um número entre 0 e 2.")
        else:
            print("Por favor, digite um número válido.")


def game():

    game_data = initialize_jogo()

    while True:
        print_tabuleiro(game_data['tabuleiro'])

        winner = verifica_ganhador(game_data['tabuleiro'])
        if winner:
            print(f"O jogador {winner} ganhou!")
            game_data['vitorias'][winner] += 1
            if not jogar_novamente():
                break
            else:
                game_data['tabuleiro'] = initialize_tabuleiro()
                continue

        if is_tabuleiro_cheio(game_data['tabuleiro']):
            print("Empate!")
            game_data['empates'] += 1
            if not jogar_novamente():
                break
            else:
                game_data['tabuleiro'] = initialize_tabuleiro()
                continue

        jogador_atual = game_data['jogadores'][game_data['jogador_atual']]
        print(f"Vez do jogador {jogador_atual}")
        row = entrada_valida("Digite o número da linha (0-2): ")
        col = entrada_valida("Digite o número da coluna (0-2): ")

        if game_data['tabuleiro'][row][col] == ' ':
            game_data['tabuleiro'] = update_tabuleiro(
                game_data['tabuleiro'], jogador_atual, (row, col))
            game_data['jogador_atual'] = (
                game_data['jogador_atual'] + 1) % 2
        else:
            print("Posição ocupada. Tente novamente.")

    print(
        f"Placar geral: Jogador X - {game_data['vitorias']['X']}, Jogador O - {game_data['vitorias']['O']}, Empates - {game_data['empates']}")


if __name__ == "__main__":
    game()
