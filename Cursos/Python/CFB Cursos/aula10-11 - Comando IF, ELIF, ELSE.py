a=10; b=20
op=input()

# && e || são and e or
if op=="+":
    print(str(a+b))
elif op=="-":
    print(str(a-b))
elif op=="*":
    print(str(a*b))
elif op=="/":
    print(str(a/b))
else:
    print("Operador inexistente")