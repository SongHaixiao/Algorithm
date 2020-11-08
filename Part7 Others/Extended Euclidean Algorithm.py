def extended_euclidean_algorithm(a, b):

    x1, y1 = 1, 0
    x2, y2 = 0, 1

    r1, r2 = a, b

    while True:

        factor = r1 // r2
        temp = r2
        r2 = r1 % r2
        r1 = temp

        if r2 == 0:
            gcd = r1
            x = x2
            y = y2
            break

        temp_x2 = x2
        temp_y2 = y2

        x2 = x1 - x2 * factor
        y2 = y1 - y2 * factor

        x1 = temp_x2
        y1 = temp_y2

    return gcd, x, y

if __name__ == "__main__":

    gcd, x, y = extended_euclidean_algorithm(1759, 550)
    print("gcd = {0}, x = {1}, y = {2}".format(gcd,x,y))
