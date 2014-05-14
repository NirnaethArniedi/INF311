clf;
n=2000;
A=[];
for i=1:n
    k=rand();
    if k<0.2 then 
        A(i,1)=1;
    elseif 0.2<=k & k<0.7 then
        A(i,1)=2
    elseif 0.7<=k & k<0.8 then
        A(i,1)=3;
    else 
        A(i,1)=4;
    end;
end;
histplot([.5,1.5,2.5,3.5,4.5],A);
plot2d3(1:4,[.2,.5,.1,.2],style=5);
show_window;