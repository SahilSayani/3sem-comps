library ieee;
use ieee.std_logic_1164.all;

entity OR_ent is
  port ( x : in std_logic;
  y : in std_logic;
  f : out std_logic);
end OR_ent;

architecture OR_arch of OR_ent is
begin
  process (x, y)
  begin
    if ((x = '0') and (y = '0')) then
      f <= '0';
    else
      f <= '1';
    end if;
  end process;
end OR_arch;
