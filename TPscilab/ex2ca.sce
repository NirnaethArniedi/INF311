clf;
A=[];
function y=f(x,m,s)
    y=1/(s*sqrt(2*%pi))*exp(-(x-m)^2/(2*s^2))
endfunction
n=20000;
racn=sqrt(n);
for i=1:n
    X=grand(1,n,'unf',-sqrt(3),sqrt(3));
    A(1,i)=sum(X)/(sqrt(n));
end;

histplot(floor(sqrt(n)),A);
x=linspace(-5,5,2*n);
plot(x,f(x,0,1));
show_window;

