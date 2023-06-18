from Application.Model.Users import Teacher, WorkersGroup


def main():
    group = WorkersGroup(
        [
            Teacher('0', 'Ivanov', 'Ivan', 'Ivanovich'),
            Teacher('1', 'Petrov', 'Petr', 'Petrovich'),
            Teacher('2', 'Vasiliev', 'Vasilii', 'Vasilievich'),
            Teacher('3', 'Kuzmin', 'Kuzma', 'Kuzmich')
        ]
    )
    print(group)

    for user in group:
        print(user)


if __name__ == '__main__':
    main()
