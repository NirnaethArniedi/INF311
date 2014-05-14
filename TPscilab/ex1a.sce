n=8
A=[]
for i=1:n
    for k=1:n
        A(i,k)=k*i
    end
end
disp(A)
z=linspace(1,n,n)
x=z'
B=x*z
disp(B)